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
	public List<Integer> getProductImageIdList(int productId) {
		return fileDao.getProductImageIdList(productId);
	}

	@Override
	public List<Integer> getProductNoticeImageIdList(int productId) {
		return fileDao.getProductNoticeImageIdList(productId);
	}

	@Override
	public int getProductDescriptionImageId(int productId) {
		return fileDao.getProductDescriptionImageId(productId);
	}
}
