package EXAM_PREP.service;

import EXAM_PREP.model.entities.Category;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryNameEnum categoryName);
}










