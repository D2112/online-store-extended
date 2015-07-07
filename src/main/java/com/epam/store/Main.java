package com.epam.store;

import com.epam.store.model.Category;
import com.epam.store.model.Product;
import com.epam.store.repository.springdatajpa.ProductRepository;
import com.epam.store.repository.springdatajpa.PurchaseRepository;
import com.epam.store.repository.springdatajpa.UserRepository;
import com.epam.store.web.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config/application-context.xml");
        Main main = context.getBean(Main.class);
        main.save();
    }

    public void save() {
        Category category = new Category("Cookies");
        category.setId(2142);

        Product one = productRepository.findOne(2240);

        /*Purchase purchase = new Purchase(
                one,
                one.getPrice().multiply(3),
                DateTime.now(),
                new Status(Status.DELIVERY),
                3
        );*/
        /*purchaseRepository.save(purchase);*/

    }
}
