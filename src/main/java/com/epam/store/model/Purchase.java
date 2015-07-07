package com.epam.store.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Purchase extends BaseEntity {
    private int quantity;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private DateTime date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    @Column(name = "user_id")
    private Integer userID;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Status status;

    public Purchase() {

    }

    public Purchase(Product product, Price price, DateTime date, Status status, int quantity, int userID) {
        this.product = product;
        this.price = price;
        this.date = date;
        this.status = status;
        this.quantity = quantity;
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Purchase purchase = (Purchase) o;

        if (date != null ? !date.equals(purchase.date) : purchase.date != null) return false;
        if (price != null ? !price.equals(purchase.price) : purchase.price != null) return false;
        if (product != null ? !product.equals(purchase.product) : purchase.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "quantity=" + quantity +
                ", date=" + date +
                ", product=" + product +
                ", price=" + price +
                ", userID=" + userID +
                ", status=" + status +
                '}';
    }
}
