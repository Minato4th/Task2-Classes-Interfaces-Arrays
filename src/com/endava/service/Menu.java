package com.endava.service;

import com.endava.entites.Order;
import com.endava.entites.products.Product;
import com.endava.entites.products.Status;
import com.endava.validator.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 3/21/2017
 */
public class Menu {

    private List<Order> orders = new ArrayList<>();
    private Validator validator = new Validator();

    private int id;
    private String userName;
    private String userSurName;
    private Date dateOfOrder;
    private List<Product> products;
    private Product product;

    private String productType;
    private int price;
    private String countryToDeliver;
    private int count;
    private int weight;
    private int deliveryPrice;
    private Status status;


    public void mainMenu(){
        boolean done = true;
        while (done) {
            done = false;
            int choice = validator.isDigit();
            System.out.println("Hello, choice option" +
                    "\n 1. Create Orders" +
                    "\n 2. Modifies Orders" +
                    "\n 3. Exit");

            if (choice == 1);
            else if (choice == 2);
            else if (choice == 3) System.out.println("Good Buy!");
            else {
                System.out.println("Wrong Command, try again");
                done = true;
            }

        }

    }

    private void createOrders(){
        boolean done = true;

        while (done) {
            done = true;

            System.out.println("Please set ID");
            this.id = validator.id(this.orders);

            System.out.println("Please set Name");
            this.userName = validator.isString();

            System.out.println("Please set Surname");
            this.userSurName = validator.surNameSet(this.userName);
            if (this.userSurName.equals("BlackListed")){
                done = false;
                break;
            }

            System.out.println("Please set Date of order in format \' 25.06.2015 \'");
            this.dateOfOrder = validator.dateSet();

            products.add(productAdd());

        }

        if (this.userSurName.equals("BlackListed")){
            mainMenu();
        } else orders.add(new Order(this.id, this.userName, this.userSurName, this.dateOfOrder, this.products));
        mainMenu();
    }

    private Product productAdd(){
        boolean done = true;

        while (done) {
            done = true;

        }

        return ;
    }
}
