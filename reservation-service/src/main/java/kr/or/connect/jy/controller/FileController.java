package kr.or.connect.jy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.jy.dto.ProductImage;
import kr.or.connect.jy.service.FileService;
import kr.or.connect.jy.service.ProductImageService;

@Controller
@RequestMapping("/files")
public class FileController {
	private String destDir = "C:\\Users\\jylee\\Work\\ReservationFiles\\";
	private String baseDir = destDir.replace("\\", File.separator); // 윈도우 사용자가 아니라면, 경로 구분 달라지도록

	private FileService fileService;
	private ProductImageService productImageService;

	@Autowired
	public FileController(FileService fileService, ProductImageService productImageService) {
		this.fileService = fileService;
		this.productImageService = productImageService;
	}

	@GetMapping
	public String fileForm() {
		return "files";
	}

	@PostMapping("/product")
	public String uploadProductImage(@RequestParam("productId") Integer productId, @RequestParam("file") MultipartFile[] files) {
		if (files != null && files.length > 0 && productId != null) {
			String productDir = baseDir + "ProductImages" + File.separator + productId;
			
			File f = new File(productDir);

			if (!f.exists()) { 
				f.mkdirs(); 
			}

			for (MultipartFile file : files) {
				String contentType = file.getContentType();
				
				String originalFilename = file.getOriginalFilename();
				long size = file.getSize();

				String uuid = UUID.randomUUID().toString(); // 중복될 일이 거의 없다.
				String saveFileName = productDir + File.separator + uuid; // 실제 저장되는 파일의 절대 경로

				Timestamp now = new Timestamp(new Date().getTime());
				kr.or.connect.jy.dto.File myFile = new kr.or.connect.jy.dto.File(1, originalFilename, saveFileName,
						size, contentType, false, now, now);
				
				int fileId = fileService.insert(myFile);
				ProductImage pi = new ProductImage();
				pi.setProductId(productId);
				pi.setType(true);
				pi.setFileId(fileId);
				
				int productImageId = productImageService.insert(pi);

				// 실제 파일을 저장함.
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
			} // for
		} // if
		return "redirect:/files";
	}
	
	@PostMapping("/usercomment")
	public String uploadUserCommentImages(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile[] files) {
		if (files != null && files.length > 0 && userId != null) {
			String userCommentsDir = baseDir + "UserCommentsImages" + File.separator + userId;
			
			File f = new File(userCommentsDir);

			if (!f.exists()) { 
				f.mkdirs(); 
			}

			for (MultipartFile file : files) {
				String contentType = file.getContentType();
				
				String originalFilename = file.getOriginalFilename();
				long size = file.getSize();

				String uuid = UUID.randomUUID().toString(); // 중복될 일이 거의 없다.
				String saveFileName = userCommentsDir + File.separator + uuid; // 실제 저장되는 파일의 절대 경로

				Timestamp now = new Timestamp(new Date().getTime());
				kr.or.connect.jy.dto.File myFile = new kr.or.connect.jy.dto.File(userId, originalFilename, saveFileName,
						size, contentType, false, now, now);
				
				int fileId = fileService.insert(myFile);

				// 실제 파일을 저장함.
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
			} // for
		} // if
		return "redirect:/files";
	}


	@GetMapping(path ="/{id}")
	public void downloadImage(@PathVariable(name = "id") long id, HttpServletResponse response) {
		// id를 이용하여 파일의 정보를 읽어온다.
		// 이 부분은 원래 db에서 읽어오는 것인데 db부분은 생략했다.
		kr.or.connect.jy.dto.File file = fileService.selectById(id);
		
		String originalFilename = file.getFileName();
		String contentType = file.getContentType();
		long fileSize = file.getFileLength();
		String saveFileName = file.getSaveFileName();

		response.setHeader("Content-Disposition", "inline; filename=\"" + originalFilename + "\";");
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
