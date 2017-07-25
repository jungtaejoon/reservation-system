package won.reservation.service;

import java.util.List;

import won.reservation.domain.File;

public interface FileService {
	public String get(Integer id);
	public List<File> getProductImgs(Integer productId);
	public List<File> getProductDetailImgs(Integer productId);
	public List<File> getReservationUserCommentImgs(Integer reservationUserCommentId);
}
