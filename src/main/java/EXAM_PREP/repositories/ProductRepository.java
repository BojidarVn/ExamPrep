package EXAM_PREP.repositories;

import EXAM_PREP.model.entities.Product;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT SUM(p.price) FROM Product AS p")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryNameEnum categoryName);

}
