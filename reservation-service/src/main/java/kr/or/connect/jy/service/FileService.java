package kr.or.connect.jy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.FileDao;
import kr.or.connect.jy.dto.File;

@Service
public class FileService {
	@Autowired
	FileDao fileDao;

	public FileService(FileDao fileDao) {
		super();
		this.fileDao = fileDao;
	}
	
	public int insert(File file) {
		return fileDao.insert(file);
	}

	public File selectById(long id) {
		return fileDao.selectById(id);
	} 

}
