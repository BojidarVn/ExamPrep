package EXAM_PREP.service.impl;

import EXAM_PREP.model.entities.Category;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import EXAM_PREP.repositories.CategoryRepository;
import EXAM_PREP.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if(categoryRepository.count()==0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryName -> {
                        Category category=new Category(categoryName, "Description for " + categoryName.name());
                        categoryRepository.save(category);
                    });
        }

    }

    @Override
    public Category findByName(CategoryNameEnum categoryName) {

        return categoryRepository
                .findByName(categoryName)
                .orElse(null);
    }
}
