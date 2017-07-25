package kr.or.connect.serviceImpl;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import kr.or.connect.domain.*;

@Service
@Transactional
public class AsyncFileServiceImpl {
	
	@Async("taskExecutor")
	public Future<FileDomain> wright(MultipartFile file, String formattedDate) {
		String uuid = UUID.randomUUID().toString();
		String saveFileName = formattedDate + File.separator + uuid;
		try(BufferedInputStream bis = new BufferedInputStream(file.getInputStream()); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(saveFileName))){
			int i = 0;
            while((i = bis.read()) != -1){
                bos.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
		FileDomain fileDomain = new FileDomain();
		fileDomain.save(file, saveFileName);
		return new AsyncResult<FileDomain>(fileDomain);
	}
}
