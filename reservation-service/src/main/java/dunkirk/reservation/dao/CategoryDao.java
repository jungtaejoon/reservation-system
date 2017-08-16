package dunkirk.reservation.dao;

import java.util.List;

import dunkirk.reservation.domain.Category;

public interface CategoryDao {

    List<Category> getList();

}
