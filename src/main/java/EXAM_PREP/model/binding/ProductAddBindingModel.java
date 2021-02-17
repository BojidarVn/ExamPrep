package EXAM_PREP.model.binding;

import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryNameEnum category;

    public ProductAddBindingModel() {
    }


    @NotBlank(message = "Cannot be empty")
    @Size(min=3, max = 20, message = "Name must be between 3 nad 20 characters")
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }


    @Size(min = 5, message = "Description must be min 5 characters")
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }


    @DecimalMin(value = "0", message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    @NotNull(message = "You must select the category")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
