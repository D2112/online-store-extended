package com.epam.store.web;

import com.epam.store.Images;
import com.epam.store.model.Category;
import com.epam.store.model.Image;
import com.epam.store.model.Price;
import com.epam.store.model.Product;
import com.epam.store.service.StoreService;
import com.epam.store.web.validation.CreateProductForm;
import com.epam.store.web.validation.CreateProductFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private static final String CATEGORIES_ATTRIBUTE_NAME = "categories";
    private static final String PRODUCTS_ATTRIBUTE_NAME = "products";
    private StoreService storeService;
    private MessageSource messageSource;
    private CreateProductFormValidator productValidator;

    @Autowired
    public AdminController(StoreService storeService, MessageSource messageSource) {
        this.storeService = storeService;
        this.messageSource = messageSource;
        productValidator = new CreateProductFormValidator();
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String showUsers(ModelMap model) {
        model.addAttribute("users", storeService.getAllNotBannedUsers());
        return "admin/admin-panel";
    }

    @RequestMapping(value = "/admin/black-list", method = RequestMethod.GET)
    public String showBlackList(ModelMap model) {
        model.addAttribute("blackList", storeService.getBannedUsers());
        return "admin/admin-panel";
    }

    @RequestMapping(value = "/admin/users/ban", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setUserBan(@RequestParam Integer userID, @RequestParam boolean banValue) {
        storeService.setUserBanValue(userID, banValue);
    }

    @RequestMapping(value = "/admin/create-product", method = RequestMethod.GET)
    public String initCreateProductForm(ModelMap model) {
        model.addAttribute(CATEGORIES_ATTRIBUTE_NAME, storeService.getCategories());
        model.addAttribute("createProductForm", new CreateProductForm());
        return "admin/create-product";
    }

    @RequestMapping(value = "/admin/create-product", method = RequestMethod.POST)
    @ResponseBody
    public Response processCreateProductForm(@Valid CreateProductForm createProductForm,
                                             BindingResult binding, Locale locale) {
        productValidator.validate(createProductForm, binding);
        Response response = new Response(messageSource, locale);
        if (binding.hasErrors()) {
            response.setStatus(Response.Status.FAIL);
            response.addErrorMessages(binding);
        } else {
            Product product = createProduct(createProductForm);
            storeService.addProduct(product);
            response.setStatus(Response.Status.SUCCESS);
            response.addMessageByKey("creating-product.message.success");
        }
        return response;
    }

    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String initCategoryManagementForm(ModelMap model) {
        model.addAttribute(CATEGORIES_ATTRIBUTE_NAME, storeService.getCategories());
        return "admin/category-management";
    }

    @RequestMapping(value = "/admin/categories/add", method = RequestMethod.PUT)
    @ResponseBody
    public Response addCategory(@RequestBody String categoryName, Locale locale) {
        Response response = new Response(messageSource, locale);
        if (storeService.isCategoryExists(categoryName)) {
            response.setStatus(Response.Status.FAIL);
            response.addMessageByKey("category-adding.error.exist");
        } else {
            storeService.addCategory(categoryName);
            response.setStatus(Response.Status.SUCCESS);
            response.addMessageByKey("category-adding.message.successAdd");
        }
        return response;
    }

    @RequestMapping(value = "/admin/categories/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteCategory(@RequestBody String categoryName, Locale locale) {
        Response response = new Response(messageSource, locale);
        storeService.deleteCategory(categoryName);
        response.setStatus(Response.Status.SUCCESS);
        response.addMessageByKey("category-adding.message.successDelete");
        return response;
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String showProductCategories(ModelMap model) {
        model.addAttribute(CATEGORIES_ATTRIBUTE_NAME, storeService.getCategories());
        return "admin/product-management";
    }

    @RequestMapping(value = "/admin/products/{category}", method = RequestMethod.GET)
    public String showProductForCategory(ModelMap model, @PathVariable("category") String category) {
        model.addAttribute(CATEGORIES_ATTRIBUTE_NAME, storeService.getCategories());
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, storeService.getProductsForCategory(category));
        return "admin/product-management";
    }

    @RequestMapping(value = "/admin/products/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducts(@RequestBody List<Integer> productIdToDelete) {
        storeService.deleteProducts(productIdToDelete);
    }

    private Product createProduct(CreateProductForm productForm) {
        String productName = productForm.getProductName();
        String categoryName = productForm.getCategoryName();
        String description = productForm.getDescription();
        String price = productForm.getPrice();
        MultipartFile imageFile = productForm.getImage();
        Image image = null;
        Category category = storeService.getCategory(categoryName);
        try {
            image = new Image(
                    imageFile.getName(),
                    imageFile.getContentType(),
                    Images.resize(imageFile.getBytes(), Image.STANDARD_WIDTH, Image.STANDARD_HEIGHT)
            );
        } catch (IOException e) {
            log.error("Error when getting bytes from file", e);
        }
        return new Product(
                productName,
                category,
                description,
                new Price(new BigDecimal(price)),
                image,
                new ArrayList<>()
        );
    }

}
