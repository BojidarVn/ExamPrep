package EXAM_PREP.service.impl;

import EXAM_PREP.model.entities.Product;
import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import EXAM_PREP.model.service.ProductServiceModel;
import EXAM_PREP.model.view.ProductViewModel;
import EXAM_PREP.repositories.ProductRepository;
import EXAM_PREP.service.CategoryService;
import EXAM_PREP.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {

        Product product=modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);


    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoryNameEnum categoryName) {
        return productRepository
                .findAllByCategory_Name(categoryName)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
