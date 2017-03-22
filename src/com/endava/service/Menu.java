package com.endava.service;

import com.endava.entites.Order;
import com.endava.entites.products.*;
import com.endava.validator.Validator;

import java.text.SimpleDateFormat;
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
    private List<Product> products = new ArrayList<>();
    private Product product;
    
    private double price;
    private String countryToDeliver;
    private int count;
    private int weight;
    private double deliveryPrice;
    private Status status;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");


    public void mainMenu(){
        boolean done = true;
        while (done) {
            done = false;

            System.out.println("Hello, choice option" +
                    "\n 1. Create Orders" +
                    "\n 2. View Orders" +
                    "\n 3. Modifies Orders" +
                    "\n 4. Exit");

            int choice = validator.isDigit();

            if (choice == 1) createOrders();
            else if (choice == 2) wievALL();
            else if (choice == 3)choiseOrders();
            else if (choice == 4) System.out.println("Good Buy!");
            else {
                System.out.println("Wrong Command, try again");
                done = true;
            }

        }

    }

    private void createOrders(){
        boolean done = true;
        this.products.clear();

        while (done) {
            done = false;

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

        }

        if (this.userSurName.equals("BlackListed")) mainMenu();

        productAdd();

        done = true;
        while (done) {
            System.out.println("Do you need to insert addition product in Order" +
                    "\n1. Yes" +
                    "\n2. No, that is all");

            int chose = validator.isDigit();
            if (chose == 1) productAdd();
            else if (chose == 2) done = false;
            else System.out.println("Incorrect format, try again");
        }

        orders.add(new Order(this.id, this.userName, this.userSurName, this.dateOfOrder, this.products));

        mainMenu();
    }

    private void productAdd(){
        boolean done = true;

        while (done) {
            done = false;

            System.out.println("Please chose product type" +
                    "\n1. Food" +
                    "\n2. Furniture" +
                    "\n3. Toys");

            int chose = validator.isDigit();
            if (chose == 1) this.product = new Food();
            else if (chose == 2) this.product = new Furniture();
            else if (chose == 3) this.product = new Toys();
            else {
                System.out.println("Incorrect number");
                done = true;
                break;
            }

            System.out.println("Please insert base price");
            this.product.setPrice(this.price = validator.isDigit());

            System.out.println("Please insert country to deliver");
            this.product.setCountryToDeliver(this.countryToDeliver = validator.countrySet());

            System.out.println("Please insert quantity");
            this.product.setCount(this.count = validator.isDigit());

            System.out.println("Please insert weight");
            this.product.setWeight(this.weight = validator.isDigit());

            this.product.setDeliveryPrice(this.deliveryPrice = validator.deliveryPriceSet(this.price, this.countryToDeliver));

            this.product.setStatus(this.status = validator.statusSet());

            this.products.add(this.product);
        }

    }


    private void choiseOrders(){
        boolean done = true;
        boolean correct = false;

        if (products.size() == 0){
            System.out.println("No orders");
            done = false;
        }

        while (done) {
            id = -1;
            System.out.println("Please Chose order by ID:");
            int choice = validator.isDigit();
            for (Order order : orders) {
                if (order.getId() == choice) {
                    correct = true;
                    done = false;
                }
                id++;
            }

            if (!correct) {
                System.out.println("Incorrect ID, please try again");
                done = true;
            } else modifiesOrders(id);

        }

        mainMenu();
    }

    private void modifiesOrders(int id){

        boolean done = true;

        while (done) {
            done = false;
            System.out.println();
            showOrder(id);
            System.out.println("Please choice what to change\n" +
                    "1. Name\n" +
                    "2. Surname\n" +
                    "3. Date of order\n" +
                    "4. Ordered products\n" +
                    "5. Dell current Order\n");
            int choice = validator.isDigit();

            if (choice == 1) orders.get(id).setUserName(validator.isString());
            else if (choice == 2) orders.get(id).setUserSurName(validator.isString());
            else if (choice == 3) orders.get(id).setDateOfOrder(validator.dateSet());
            else if (choice == 4) choseProduct(id);
            else if (choice == 5) {
                orders.remove(id);
                mainMenu();
            }
            else {
                System.out.println("Incorrect command, please try again");
                done = true;
            }

        }

    }

    private void choseProduct(int id){

        boolean done = true;

        while (done) {
            done = false;
            System.out.println();
            showProduct(id);
            System.out.println("Please choice \n" +
                    "1. Product order number\n" +
                    "2. Add new Product\n");
            int choice = validator.isDigit();

            if (choice == 1) modifierProduct(id, choice);
            else if (choice == 2) {
                productAdd();
                orders.get(id).getProducts().add(product);
            }else {
                System.out.println("Incorrect command, please try again");
                done = true;
            }
        }
    }

    private void modifierProduct(int id, int product){

        boolean done = true;

        while (done) {
            done = false;
            System.out.println();
            showProduct(id);
            System.out.println("Please choice what to change\n" +
                    "1. Base Price\n" +
                    "2. Country\n" +
                    "3. Count\n" +
                    "4. Weight\n" +
                    "5. Delivery Status\n" +
                    "6. Dell current Product\n");
            int choice = validator.isDigit();

            if (choice == 1) orders.get(id).getProducts().get(product).setPrice(validator.isDigit());
            else if (choice == 2) orders.get(id).getProducts().get(product).setCountryToDeliver(validator.countrySet());
            else if (choice == 3) orders.get(id).getProducts().get(product).setCount(validator.isDigit());
            else if (choice == 4) orders.get(id).getProducts().get(product).setWeight(validator.isDigit());
            else if (choice == 5) orders.get(id).getProducts().get(product).setStatus(validator.statusSet());
            else if (choice == 6) orders.get(id).getProducts().remove(product);
            else {
                System.out.println("Incorrect command, please try again");
                done = true;
            }

        }

    }


    private void wievALL(){
        boolean done = true;

        if (products.size() == 0){
            System.out.println("No orders");
            done = false;
        }

        if (done){
            System.out.println("Current Orders and Products");
            for (Order order : orders) {
                showOrder(order.getId());
            }
        }

        mainMenu();
    }

    private void showOrder(int id){

        for (Order order : orders) {
            if (order.getId() == id){
                System.out.println("ID :" + order.getId());
                System.out.println("Name :" + order.getUserName());
                System.out.println("Surname :" + order.getUserSurName());
                System.out.println("Date of order :" + simpleDateFormat.format(order.getDateOfOrder()));
                System.out.println("Ordered products :\n");
                showProduct(id);
            }
        }
    }

    private void showProduct(int id){
        for (Order order : orders) {
            if (order.getId() == id){
                for (int i = 0; i < order.getProducts().size(); i++) {
                    System.out.println("Product order number :" + i);
                    System.out.println("Product Type :" + order.getProducts().get(i).getProductType());
                    System.out.println("Base Price :" + order.getProducts().get(i).getPrice());
                    System.out.println("Country :" + order.getProducts().get(i).getCountryToDeliver());
                    System.out.println("Count :" + order.getProducts().get(i).getCount());
                    System.out.println("Weight :" + order.getProducts().get(i).getWeight());
                    System.out.println("Delivery Price :" + order.getProducts().get(i).getDeliveryPrice());
                    System.out.println("Delivery Status :" + order.getProducts().get(i).getStatus());
                    System.out.println();
                }
            }
        }
    }

}
