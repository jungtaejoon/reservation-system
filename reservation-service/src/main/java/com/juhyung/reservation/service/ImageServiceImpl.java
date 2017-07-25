package com.juhyung.reservation.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.juhyung.reservation.domain.Image;
import com.juhyung.reservation.domain.ProductImage;
import com.juhyung.reservation.persistence.ImageDAO;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageDAO imageDao;
	
	@Override
	@Transactional
	public void createImage(String title, MultipartFile[] files, ProductImage productImage) {

        if(files != null && files.length > 0){
        	Image image = new Image();

        	//BASE_DIR은 Desktop directory
        	String formattedDate = BASE_DIR + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());
            
        	File f = new File(formattedDate);
            
            if(!f.exists()){
                f.mkdirs(); //디렉토리 생성
            }
            
            for(MultipartFile file : files) {
            	image.setContentType(file.getContentType());
            	image.setFileName(file.getOriginalFilename());
            	image.setFileLength(file.getSize());
                String uuid = UUID.randomUUID().toString(); // 중복을 최대한 피하는 방법
                image.setSaveFileName(formattedDate + File.separator + uuid);
            	image.setUserId(1);
            	productImage.setFileId(imageDao.insertImage(image));
            	imageDao.insertImageProduct(productImage);
            	
                try(InputStream in = file.getInputStream();
                    FileOutputStream fos = new FileOutputStream(image.getSaveFileName())){
                    
                	int readCount = 0;
                    byte[] buffer = new byte[512];
                    while((readCount = in.read(buffer)) != -1){
                        fos.write(buffer,0,readCount);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            //TODO user가 없는 상황이므로 강제적으로 user id를 세팅해준다.
        }
	}


	@Override
	public Image getImageByFileId(int fileId) {
		return imageDao.selectImageByFileId(fileId);
	}
	
	//comment -file(image)
	@Override
	public List<Integer> getFilesByCommentId(int commentId) {
		List<Integer> files = imageDao.selectFilesByCommentId(commentId);
		if(files.size() > 0){
			return files;
		}else{
			return null; //exception
		}
	}


}
