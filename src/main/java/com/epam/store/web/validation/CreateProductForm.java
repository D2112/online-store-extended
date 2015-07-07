package com.epam.store.web.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateProductForm {
    @NotNull
    private String categoryName;

    @NotNull
    @Size(min = 2, max = 24)
    private String productName;

    @NotNull
    @Size(max = 12)
    @Pattern(regexp = "^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$") //only positive digits
    private String price;

    @Size(max = 1024)
    private String description;

    @NotNull
    private MultipartFile image;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
