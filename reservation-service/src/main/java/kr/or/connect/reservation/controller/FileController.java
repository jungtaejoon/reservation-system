package kr.or.connect.reservation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dao.FileDao;
import kr.or.connect.reservation.domain.FileDomain;

@Controller
@RequestMapping("/files")
public class FileController {
	
	@Value("${spring.uploadfile.root-directory}")
	private String localDirectory;
	
	@Autowired
	private FileDao dao;
	
	@GetMapping
	public String fileform() {
		return "files";
	}

	@PostMapping
	public String uploadFile(
			@RequestParam("title") String title, 
			@RequestParam("file") MultipartFile[] files) {

		if (title != null && !title.isEmpty() && files != null && files.length > 0) {

			String curtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String savePath = localDirectory + File.separator + curtime;
			
			// 실제 저장될 폴더가 없으면 폴더 생성
			if (!new File(savePath).isDirectory()) {
				new File(savePath).mkdirs();
			}
			
			for (MultipartFile file : files) {
				String contentType = file.getContentType();
				String originalFilename = file.getOriginalFilename();
				long size = file.getSize();

				String uuid = UUID.randomUUID().toString();
				String saveFileName = savePath + File.separator + uuid;

				// try-with-resource 구문. close()를 할 필요가 없다. java 7 이상에서 가능
				try (InputStream in = file.getInputStream();
						FileOutputStream fos = new FileOutputStream(saveFileName)) {
					
					int readCount = 0;
					byte[] buffer = new byte[512];
					
					while ((readCount = in.read(buffer)) != -1) {
						fos.write(buffer, 0, readCount);
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				FileDomain f = new FileDomain();
				f.setUserId(1);
				f.setContentType(contentType);
				f.setFileName(originalFilename);
				f.setSaveFileName(saveFileName);
				f.setFileLength(size);
				dao.insert(f);
				
			}
		}

		return "redirect:/files";
	}

	
	@GetMapping(path = "/{id}")
	public void downloadReservationUserCommentImage(
			@PathVariable(name = "id") long id, 
			HttpServletResponse response) {

		FileDomain f = dao.selectById(id);
		
		long fileSize = f.getFileLength();
		String contentType = f.getContentType();
		String saveFileName = f.getSaveFileName();
		String originalFilename = f.getSaveFileName();

		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Length", "" + fileSize);
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		java.io.File readFile = new java.io.File(saveFileName);
		if (!readFile.exists()) { // 파일이 존재하지 않다면
			throw new RuntimeException("file not found");
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(readFile);
			FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
			response.getOutputStream().flush();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				fis.close();
			} catch (Exception ex) {
				// 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
			}
		}

	}

}
