package won.reservation.service;

import java.util.List;

import won.reservation.dto.CommentInfo;

public interface ReservationUserCommentService {
	public List<CommentInfo> get(Integer productId);
	public Double getAvgScore(Integer productId);
}
