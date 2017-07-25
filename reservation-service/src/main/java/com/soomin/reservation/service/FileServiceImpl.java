package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.FileDao;
import com.soomin.reservation.domain.Files;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDao fileDao;
	
	@Override
	public long saveFile(Files file) {
		// TODO Auto-generated method stub
		return fileDao.insert(file);
	}

	@Override
	public List<Files> loadFile(long id) {
		// TODO Auto-generated method stub
		return fileDao.selectById(id);
	}
	
}
