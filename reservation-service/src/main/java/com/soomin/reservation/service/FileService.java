package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.Files;

public interface FileService {
	public long saveFile(Files file);
	public List<Files> loadFile(long id);
}
