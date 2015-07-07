package com.epam.store.service;

import com.epam.store.model.*;

import java.util.List;

public interface StoreService {

    List<Product> getRecentProduct(int numberOfProducts);

    User registerUser(String name, String email, String password);

    boolean isEmailRegistered(String email);

    User authenticateUser(String email, String password);

    Category addCategory(String categoryName);

    List<Category> getCategories();

    void deleteCategory(String categoryName);

    boolean isCategoryExists(String categoryName);

    Category getCategory(String name);

    void addProduct(Product product);

    List<Product> getProductsForCategory(String category);

    void deleteProducts(List<Integer> productIdToDelete);

    List<User> getAllNotBannedUsers();

    List<User> getBannedUsers();

    void setUserBanValue(int userID, boolean ban);

    List<Purchase> getUserPurchaseList(int userID);

    Image getProductImage(int imageID);

    Product getProduct(int productID);

    void confirmOrder(int userID, Cart cart);
}
