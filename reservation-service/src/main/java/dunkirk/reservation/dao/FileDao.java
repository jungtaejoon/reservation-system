package dunkirk.reservation.dao;

import java.util.List;

public interface FileDao {
    String getSaveFileName(int id);

    List<Integer> getProductImageIdList(int productId);

    List<Integer> getProductNoticeImageIdList(int productId);

    int getProductDescriptionImageId(int productId);
}
