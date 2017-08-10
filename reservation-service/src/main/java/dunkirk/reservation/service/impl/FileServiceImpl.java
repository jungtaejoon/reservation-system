package dunkirk.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.FileDao;
import dunkirk.reservation.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	private FileDao fileDao;
	
	@Autowired
	public FileServiceImpl(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	@Override
	public String getSaveFileName(int id) {
		return fileDao.getSaveFileName(id);
	}

	@Override
	public List<Integer> getProductImageList(int productId) {
		return fileDao.getProductImageList(productId);
	}

	@Override
	public List<Integer> getProductNoticeImageList(int productId) {
		return fileDao.getProductNoticeImageList(productId);
	}

	@Override
	public int getProductInformationImage(int productId) {
		return fileDao.getProductInformationImage(productId);
	}
}
