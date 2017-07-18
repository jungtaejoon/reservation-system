package kr.or.reservation.serviceImpl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.reservation.dao.CategoryDao;
import kr.or.reservation.dao.ProductForDetailDao;
import kr.or.reservation.domain.ProductForDetail;
import kr.or.reservation.service.ProductForDetailService;

@Service
public class ProductForDetailServiceImpl implements ProductForDetailService{

	ProductForDetailDao productForDetailDao ;
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    public ProductForDetailServiceImpl(ProductForDetailDao productForDetailDao) {
		this.productForDetailDao = productForDetailDao;
	}
	
	@Override
	public ProductForDetail selectOne(int id) {
		// TODO Auto-generated method stub
		// 시간이 지낫을 경우, saleFlage를 3으로 두어, 판매 종료를 설정함.
		ProductForDetail detail =productForDetailDao.selectOne(id);
		Timestamp t1 = new Timestamp(System.currentTimeMillis());
		if(detail.getSalesEnd().getTime() - t1.getTime()  < 0) {
			detail.setSalesFlag("3");
		}
		return detail;
	}

}
