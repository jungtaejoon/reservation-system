package won.reservation.api;

import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import won.reservation.domain.File;
import won.reservation.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {
	
	private FileService fileService;
	
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@GetMapping
	@RequestMapping("/comments/{commentId}")
	public List<File> readComments(@PathVariable(name="commentId") Integer reservationUserCommentId){
		return fileService.getReservationUserCommentImgs(reservationUserCommentId);
	}
	
	@GetMapping("/{fileId}")
	public void read(@PathVariable(name="fileId") int fileId, HttpServletResponse resp) {	
		
        String contentType = "image/jpeg";
        String saveFileName = fileService.get(fileId);

        resp.setHeader("Content-Transfer-Encoding", "binary");
        resp.setHeader("Content-Type", contentType);
        resp.setHeader("Pragma", "no-cache;");
        resp.setHeader("Expires", "-1;");

        java.io.File readFile = new java.io.File(saveFileName);
        if(!readFile.exists()){ // 파일이 존재하지 않다면
            throw new RuntimeException("file not found");
        }

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(readFile);
            FileCopyUtils.copy(fis, resp.getOutputStream());
            resp.getOutputStream().flush();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                fis.close();
            }catch(Exception e){
                
            }
        }

	}
	
}
