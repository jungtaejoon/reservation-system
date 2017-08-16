package dunkirk.reservation.service;

import java.util.List;

public interface FileService {
    String getSaveFileName(int id);

    List<Integer> getProductImageIdList(int productId);

    List<Integer> getProductNoticeImageIdList(int productId);

    int getProductDescriptionImageId(int productId);
}
