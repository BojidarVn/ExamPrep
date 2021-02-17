package EXAM_PREP.service;

import EXAM_PREP.model.entities.Category;
import EXAM_PREP.model.entities.Product;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import EXAM_PREP.model.service.ProductServiceModel;
import EXAM_PREP.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategory(CategoryNameEnum categoryName);

    void buyById(String id);

    void buyAll();
}
