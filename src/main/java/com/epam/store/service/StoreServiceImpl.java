package com.epam.store.service;

import com.epam.store.PasswordEncryptor;
import com.epam.store.model.*;
import com.epam.store.repository.springdatajpa.*;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private RoleRepository roleRepository;
    private PurchaseRepository purchaseRepository;
    private ImageRepository imageRepository;
    private StatusRepository statusRepository;

    //constructor
    @Autowired
    public StoreServiceImpl(UserRepository userRepository,
                            ProductRepository productRepository,
                            CategoryRepository categoryRepository,
                            RoleRepository roleRepository,
                            PurchaseRepository purchaseRepository,
                            ImageRepository imageRepository,
                            StatusRepository statusRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
        this.purchaseRepository = purchaseRepository;
        this.imageRepository = imageRepository;
        this.statusRepository = statusRepository;
        initializeDatabaseConstants();
    }

    public List<Product> getProductsForCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    @Transactional
    public void deleteProducts(List<Integer> productIdToDelete) {
        productIdToDelete.forEach(productRepository::delete);
    }

    @Override
    public List<Product> getRecentProduct(int numberOfProducts) {
        return productRepository.getRecentProducts(numberOfProducts);
    }

    @Override
    public User registerUser(String name, String email, String password) {
        if (isEmailRegistered(email)) {
            throw new ServiceException("User with such email has been already registered");
        }
        User user = new User(
                name,
                email,
                roleRepository.findByName(Role.USER_ROLE_NAME),
                PasswordEncryptor.encrypt(password),
                false
        );
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmailRegistered(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    @Override
    public List<Category> getCategories() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    public Category addCategory(String categoryName) {
        return categoryRepository.save(new Category(categoryName));
    }

    @Override
    public void deleteCategory(String categoryName) {
        Category categoryToDelete = getCategory(categoryName);
        if (categoryToDelete == null) {
            throw new ServiceException("Such category doesn't exist: " + categoryName);
        }
        categoryRepository.delete(categoryToDelete);
    }

    public Category getCategory(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public boolean isCategoryExists(String name) {
        return categoryRepository.findByName(name) != null;
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findOne(id);
    }

    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean isProductExist(String productName) {
        return getProduct(productName) != null;
    }

    public Product getProduct(String productName) {
        return productRepository.findByName(productName);
    }

    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public User findUser(String email) {
        return userRepository.findFirstByEmail(email);
    }

    @Transactional(readOnly = true)
    public User findUser(int userID) {
        return userRepository.findOne(userID);
    }

    @Transactional
    public void changeUserPassword(User user, String newPassword) {
        Password encryptedNewPassword = PasswordEncryptor.encrypt(newPassword);
        user.setPassword(encryptedNewPassword);
        userRepository.save(user);
    }

    /**
     * Checks if user with such email and password exists in database.
     * And return found user if exist.
     *
     * @param email    user's email
     * @param password user's password
     * @return User object from database, or null, if such user not found
     */
    public User authenticateUser(String email, String password) {
        User foundUser = findUser(email);
        if (foundUser != null && PasswordEncryptor.comparePasswords(password, foundUser.getPassword())) {
            return foundUser;
        }
        return null;
    }

    public List<User> getAllNotBannedUsers() {
        return Lists.newArrayList(userRepository.findByBannedFalse());
    }

    @Override
    public List<User> getBannedUsers() {
        return userRepository.findByBannedTrue();
    }

    @Override
    public void setUserBanValue(int userID, boolean banValue) {
        User user = findUser(userID);
        if (user == null) return;
        user.setBanned(banValue);
        userRepository.save(user);
    }

    @Override
    public List<Purchase> getUserPurchaseList(int userID) {
        return purchaseRepository.findAllByUserID(userID);
    }

    @Override
    public Image getProductImage(int imageID) {
        return imageRepository.findOne(imageID);
    }

    @Override
    @Transactional
    public void confirmOrder(int userID, Cart cart) {
        List<Purchase> purchaseList = convertProductsIntoPurchaseList(cart.getProducts(), userID);
        purchaseRepository.save(purchaseList);
        cart.removeAllProducts();
    }

    private List<Purchase> convertProductsIntoPurchaseList(List<Product> products, int userID) {
        List<Purchase> purchaseList = new ArrayList<>();
        Set<Product> uniqueProducts = new HashSet<>(products);
        for (Product uniqueProduct : uniqueProducts) {
            int productQuantity = Collections.frequency(products, uniqueProduct);
            Purchase purchase = new Purchase(
                    uniqueProduct,
                    uniqueProduct.getPrice().multiply(productQuantity),
                    DateTime.now(),
                    statusRepository.findByName(Status.DELIVERY),
                    productQuantity,
                    userID
            );
            purchaseList.add(purchase);
        }
        return purchaseList;
    }

    private void initializeDatabaseConstants() {
        //create roles in database if such doesn't exist
        Role userRole = roleRepository.findByName(Role.USER_ROLE_NAME);
        Role adminRole = roleRepository.findByName(Role.ADMIN_ROLE_NAME);
        if (userRole == null) roleRepository.save(new Role(Role.USER_ROLE_NAME));
        if (adminRole == null) roleRepository.save(new Role(Role.ADMIN_ROLE_NAME));

        Status delivery = statusRepository.findByName(Status.DELIVERY);
        Status canceled = statusRepository.findByName(Status.CANCELED);
        Status paid = statusRepository.findByName(Status.PAID);
        Status unpaid = statusRepository.findByName(Status.UNPAID);
        if (delivery == null) statusRepository.save(new Status(Status.DELIVERY));
        if (canceled == null) statusRepository.save(new Status(Status.CANCELED));
        if (paid == null) statusRepository.save(new Status(Status.PAID));
        if (unpaid == null) statusRepository.save(new Status(Status.UNPAID));
    }
}
