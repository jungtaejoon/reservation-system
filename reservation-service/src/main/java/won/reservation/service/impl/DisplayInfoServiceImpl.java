package won.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.DisplayInfoDao;
import won.reservation.domain.DisplayInfo;
import won.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

	private DisplayInfoDao dao;
	
	@Autowired
	public DisplayInfoServiceImpl(DisplayInfoDao dao) {
		this.dao  = dao;
	}
	
	@Override
	public DisplayInfo get(Integer productId) {
		if(productId < 1 || productId == null) {
			return null;
		}
		return dao.select(productId);
	}
	
}
