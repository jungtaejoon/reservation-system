package kr.or.connect.api;

import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@RestController
@RequestMapping("/files")
public class FileController {

	FileService fileService;

	@Autowired
	public FileController(FileService fileService) {
		super();
		this.fileService = fileService;
	}
	
	@GetMapping("/{fileId:[\\d]+}")
	public FileSystemResource getFile(@PathVariable Long fileId) {
		File file = new File(fileService.getFile(fileId).getSaveFileName());
        if(!file.exists()){ // 파일이 존재하지 않다면
            throw new RuntimeException("file not found");
        }
		return new FileSystemResource(file);
	}	
}