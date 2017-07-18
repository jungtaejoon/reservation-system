package kr.or.reservation.service;

import java.util.List;

import kr.or.reservation.domain.Img;

public interface ImgService {
	public List<Img> selectList(int id);
	public Img selectOne(long fileId);
}
