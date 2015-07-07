package com.epam.store.web;

import com.epam.store.model.Cart;
import com.epam.store.model.Image;
import com.epam.store.model.Product;
import com.epam.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private static final int RECENT_PRODUCT_AMOUNT = 9;
    private StoreService storeService;

    @Autowired
    public ProductController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showRecentlyAddedProducts(Map<String, Object> model) {
        List<Product> recentProducts = storeService.getRecentProduct(RECENT_PRODUCT_AMOUNT);
        model.put("products", recentProducts);
        return "home";
    }

    @RequestMapping(value = "/image/{imageID}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getProductImage(@PathVariable int imageID) {
        Image image = storeService.getProductImage(imageID);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(image.getContentType()));
        return new ResponseEntity<>(image.getContent(), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addToCart/{productID}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProductToCart(@PathVariable int productID, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        Product product = storeService.getProduct(productID);
        cart.addProduct(product);
    }

    @RequestMapping(value = "/deleteFromCart", method = RequestMethod.POST)
    public String deleteFromCart(@RequestBody List<Integer> productIdToDelete, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        productIdToDelete.forEach(cart::removeProduct);
        return "fragment/cart-info-table"; //return html with refreshed cart info
    }
}
