package com.soomin.reservation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

import com.soomin.reservation.domain.Files;
import com.soomin.reservation.domain.ProductImage;
import com.soomin.reservation.service.FileService;
import com.soomin.reservation.service.ProductImageService;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;
    @Autowired
    ProductImageService productImageService;
	
	private String baseDir = "d:" + File.separator + "temp" + File.separator; // c:\temp 디렉토리를 미리 만들어둔다.

    
    @GetMapping
    public String fileform(){
        return "file";
    }

    @PostMapping
    public String create(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile[] files){

        if(files != null && files.length > 0){

            String formattedDate = baseDir + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());
            File f = new File(formattedDate);
            if(!f.exists()){ 
                f.mkdirs(); 
            }

            for(MultipartFile file : files) {
                Files saveFile = new Files();
            	String contentType = file.getContentType();
                String name = file.getName();
                String originalFilename = file.getOriginalFilename();
                long size = file.getSize();

                String uuid = UUID.randomUUID().toString(); 
                String saveFileName = formattedDate + File.separator + uuid; 

                saveFile.setContent_type(contentType);
                saveFile.setFile_name(originalFilename);
                saveFile.setSave_file_name(saveFileName);
                saveFile.setFile_length(size);
                saveFile.setUser_id(1);

                long flag = fileService.saveFile(saveFile);
                
                try(
	                InputStream in = file.getInputStream();
	                FileOutputStream fos = new FileOutputStream(saveFileName)){
	                    int readCount = 0;
	                    byte[] buffer = new byte[512];
	                    while((readCount = in.read(buffer)) != -1){
	                        fos.write(buffer,0,readCount);
	                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }

        return "redirect:/file";
    }

    @GetMapping(path="/{id}")
    public void displayImagesByFileId(
            @PathVariable(name="id") long id,
            HttpServletResponse response
    ){
    	List<Files> loadFiles = fileService.loadFile(id);

    	for(Files loadFile : loadFiles) {
    		String originalFilename = loadFile.getFile_name();
            String contentType = loadFile.getContent_type();
            long fileSize = loadFile.getFile_length();
            String saveFileName = loadFile.getSave_file_name();

            response.setHeader("Content-Disposition", "inline; filename=\"" + originalFilename + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Type", contentType);
            response.setHeader("Content-Length", ""+ fileSize);
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");

            java.io.File readFile = new java.io.File(saveFileName);
            if(!readFile.exists()){ 
                throw new RuntimeException("file not found");
            }

            FileInputStream fis = null;
            try{
                fis = new FileInputStream(readFile);
                FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
                response.getOutputStream().flush();
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }finally {
                try {
                    fis.close();
                }catch(Exception ex){
                    // 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
                }
            }
    	}
    }
    @GetMapping(path="/product/{id}")
    public void displayImageByProductId(
    		@PathVariable(name="id") long id,
            HttpServletResponse response
    ) {
    	ProductImage images = productImageService.getThumbnailImage(id);
		List<Files> loadFiles = fileService.loadFile(images.getFile_id());

    	for(Files loadFile : loadFiles) {
    		String originalFilename = loadFile.getFile_name();
            String contentType = loadFile.getContent_type();
            long fileSize = loadFile.getFile_length();
            String saveFileName = loadFile.getSave_file_name();

            response.setHeader("Content-Disposition", "inline; filename=\"" + originalFilename + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Type", contentType);
            response.setHeader("Content-Length", ""+ fileSize);
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");

            java.io.File readFile = new java.io.File(saveFileName);
            if(!readFile.exists()){ 
                throw new RuntimeException("file not found");
            }

            FileInputStream fis = null;
            try{
                fis = new FileInputStream(readFile);
                FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
                response.getOutputStream().flush();
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }finally {
                try {
                    fis.close();
                }catch(Exception ex){
                    // 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
                }
            }
    	}
    	
    }
}