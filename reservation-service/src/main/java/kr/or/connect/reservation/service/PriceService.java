package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.PriceDao;
import kr.or.connect.reservation.domain.Price;

@Service
public class PriceService {
	private PriceDao dao;
	
	@Autowired
	public PriceService(PriceDao dao) {
		this.dao = dao;
	}
	
	public List<Price> getByProductId(Integer productId) {
		return dao.getByProductId(productId);
	}
}
