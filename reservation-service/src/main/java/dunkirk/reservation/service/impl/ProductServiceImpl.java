package dunkirk.reservation.service.impl;

import java.util.List;

import dunkirk.reservation.dao.ProductPriceDao;
import dunkirk.reservation.domain.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ProductDao;
import dunkirk.reservation.dto.ProductForDetailDto;
import dunkirk.reservation.dto.ProductForMainDto;
import dunkirk.reservation.dto.ProductForReservationDto;
import dunkirk.reservation.service.CommentService;
import dunkirk.reservation.service.FileService;
import dunkirk.reservation.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    private ProductPriceDao productPriceDao;
    private CommentService commentService;
    private FileService fileService;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, ProductPriceDao productPriceDao, CommentService commentService, FileService fileService) {
        this.productDao = productDao;
        this.productPriceDao = productPriceDao;
        this.commentService = commentService;
        this.fileService = fileService;
    }

    @Override
    public List<ProductForMainDto> getList(int categoryId, int page) {
        return productDao.getList(categoryId, page);
    }

    @Override
    public ProductForDetailDto getDetail(int id) {
        ProductForDetailDto product = productDao.getDetail(id);
        product.setComments(commentService.getListByProduct(0, 3, id));
        product.setBannerImageIdList(fileService.getProductImageIdList(id));
        product.setDescriptionImageId(fileService.getProductDescriptionImageId(id));
        product.setNoticeImageIdList(fileService.getProductNoticeImageIdList(id));
        return product;
    }

    @Override
    public ProductForReservationDto getForReservation(int id) {
        ProductForReservationDto product = productDao.getForReservation(id);
        product.setProductPrices(productPriceDao.getList(id));
        return product;
    }

}
