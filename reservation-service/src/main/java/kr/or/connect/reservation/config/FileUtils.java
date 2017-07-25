package kr.or.connect.reservation.config;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

import kr.or.connect.reservation.domain.File;

public class FileUtils {

    public static void downLoadSetting (HttpServletResponse response, File image) {
    	
    	String originalFilename = image.getFile_name();
	    String contentType = image.getContent_type();
	    int fileSize = image.getFile_length();
	    String saveFileName = image.getSave_file_name();
    	
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\";");
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
	        FileCopyUtils.copy(fis, response.getOutputStream()); 
	        response.getOutputStream().flush();
	    }catch(Exception ex){
	        throw new RuntimeException(ex);
	    }finally {
	        try {
	            fis.close();
	        }catch(Exception ex){
	            
	        }
	    }
    }

}
