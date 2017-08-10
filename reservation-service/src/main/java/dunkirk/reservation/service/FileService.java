package dunkirk.reservation.service;

import java.util.List;

public interface FileService {
	public String getSaveFileName(int id);
	public List<Integer> getProductImageList(int productId);
	public List<Integer> getProductNoticeImageList(int productId);
	public int getProductInformationImage(int productId);
}
