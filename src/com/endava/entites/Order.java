package com.endava.entites;

import com.endava.entites.products.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 3/21/2017
 */
public class Order {

    int id;
    String userName;
    String userSurName;
    Date dateOfOrder;
    List<Product> products = new ArrayList<>();

    public Order(int id, String userName, String userSurName, Date dateOfOrder, List<Product> products) {
        this.id = id;
        this.userName = userName;
        this.userSurName = userSurName;
        this.dateOfOrder = dateOfOrder;
        this.products = products;
    }

    @Override
    public String toString() {
        return "com.endava.entites.Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSurName='" + userSurName + '\'' +
                ", dateOfOrder=" + dateOfOrder +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (userName != null ? !userName.equals(order.userName) : order.userName != null) return false;
        if (userSurName != null ? !userSurName.equals(order.userSurName) : order.userSurName != null) return false;
        if (dateOfOrder != null ? !dateOfOrder.equals(order.dateOfOrder) : order.dateOfOrder != null) return false;
        return products != null ? products.equals(order.products) : order.products == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSurName != null ? userSurName.hashCode() : 0);
        result = 31 * result + (dateOfOrder != null ? dateOfOrder.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurName() {
        return userSurName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
