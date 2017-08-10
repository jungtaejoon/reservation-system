package dunkirk.reservation.dao;

import java.util.List;

public interface FileDao {
	public String getSaveFileName(int id);
	public List<Integer> getProductImageList(int productId);
	public List<Integer> getProductNoticeImageList(int productId);
	public int getProductInformationImage(int productId);
}
