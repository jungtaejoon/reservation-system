package kr.or.connect.serviceImpl;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import kr.or.connect.dao.*;
import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	private static final String BASE_DIR = "c:" + File.separator + "dev" + File.separator + "temp" + File.separator;

	private FileDao fileDao;
	private ProductService productService;
	private AsyncFileServiceImpl asyncFileService;

	@Autowired
	public FileServiceImpl(FileDao fileDao, ProductService productService, AsyncFileServiceImpl asyncFileService) {
		super();
		this.fileDao = fileDao;
		this.productService = productService;
		this.asyncFileService = asyncFileService;
	}

	@Override
	public List<ProductImage> insertImages(Long productId, MultipartFile mainImage, MultipartFile[] subImages) {
        String formattedDate = BASE_DIR + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());
        File f = new File(formattedDate);
        if(!f.exists()){ 
            f.mkdirs();
        }
        
        List<ProductImage> list = new ArrayList<>();
		if (mainImage != null && !mainImage.isEmpty()) {
			Future<FileDomain> future = asyncFileService.wright(mainImage, formattedDate);
			FileDomain savedFile;
			try {
				savedFile = fileDao.insert(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			ProductImage productImage = new ProductImage();
			productImage.save(productId, savedFile, 1);
			list.add(productService.insertImage(productImage));
		}
		if (subImages != null && subImages.length > 0) {
			for (MultipartFile file : subImages) {
				if(!file.isEmpty()) {
					Future<FileDomain> future = asyncFileService.wright(file, formattedDate);
					FileDomain savedFile;
					try {
						savedFile = fileDao.insert(future.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					ProductImage productImage = new ProductImage();
					productImage.save(productId, savedFile, 2);
					list.add(productService.insertImage(productImage));
				}
			}
		}
		return list;
	}

//	@SuppressWarnings("unchecked")
//	@Async
//	public Future<FileDomain> wrightFile(MultipartFile file, String formattedDate) {
//		String uuid = UUID.randomUUID().toString();
//		String saveFileName = formattedDate + File.separator + uuid;
//		try(BufferedInputStream bis = new BufferedInputStream(file.getInputStream()); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(saveFileName))){
//			int i = 0;
//            while((i = bis.read()) != -1){
//                bos.write(i);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//		FileDomain fileDomain = new FileDomain();
//		fileDomain.save(file, saveFileName);
//		Future future.
//		return (Future<FileDomain>) fileDao.insert(fileDomain);
//	}

	@Override
	public FileDomain getFile(Long fileId) {
		return fileDao.getFile(fileId);
	}

}
