package kr.or.connect.jy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.connect.jy.dto.ReservationUserComment;

@Service
public class ReservationUserCommentService {

	public List<ReservationUserComment> selectUserCommentsByProductId(@PathVariable int productId) {
		List<ReservationUserComment> tempList = new ArrayList<ReservationUserComment>();
		ReservationUserComment ruc = new ReservationUserComment();
		ruc.setId(1);
		ruc.setProductId(1);
		ruc.setUserId(1);
		ruc.setScore(3.5);
		ruc.setComment("코멘트");

		for (int i = 0; i < 10; i++) {
			tempList.add(ruc);
		}
		return tempList;

	}

}
