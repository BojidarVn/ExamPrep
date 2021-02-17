package EXAM_PREP.repositories;

import EXAM_PREP.model.entities.Category;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {


    Optional<Category> findByName(CategoryNameEnum name);
}
