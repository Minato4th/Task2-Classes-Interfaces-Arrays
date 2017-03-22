package com.endava.validator;

import com.endava.entites.Order;
import com.endava.entites.country.CountryList;
import com.endava.entites.products.Status;
import com.endava.limits.BlackList;
import com.endava.limits.CountrySupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 3/21/2017
 */
public class Validator {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BlackList blackList = new BlackList();
    CountrySupport countrySupport = new CountrySupport();
    CountryList countryList = new CountryList();
    Status status;

    public String isString(){
        boolean done = true;
        String string = "";

        while (done) {

            done = false;
            try {
                string = reader.readLine();
            } catch (IOException e) {
                System.out.println("Something go wrong, try again");
                done = true;
            }

        }

        return string;
    }

    public int isDigit(){
        boolean done = true;
        String numS = "";

        while (done) {

            done = false;
            numS = isString();

            for (int i = 0; i < numS.length(); i++) {
                if (!Character.isDigit(numS.charAt(i))){
                    System.out.println("Wrong number format, please try again");
                    done = true;
                    break;
                }
            }

        }

        return Integer.parseInt(numS);
    }

    public Date dateSet(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        boolean done = true;
        String dateS = "";

        while (done){
            done = false;

            try {
                dateS = reader.readLine();
            } catch (IOException e) {
                System.out.println("Something go wrong, try again");
                done = true;
            }

            if (Character.isDigit(dateS.charAt(0)) && Character.isDigit(dateS.charAt(1))
                && Character.isDigit(dateS.charAt(3)) && Character.isDigit(dateS.charAt(4))
                && Character.isDigit(dateS.charAt(6)) && Character.isDigit(dateS.charAt(7))
                && Character.isDigit(dateS.charAt(8)) && Character.isDigit(dateS.charAt(9))
                && dateS.charAt(2) == '.' && dateS.charAt(2) == '.'){

                try {
                    date = simpleDateFormat.parse(dateS);
                } catch (ParseException e) {
                    System.out.println("Something go wrong, try again");
                    done = true;
                }
            } else{
                System.out.println("Wrong Date format, try again '25.06.2015 ' :");
                done = true;
            }

            System.out.println(done);
        }
        return date;
    }

    public String surNameSet(String name){
        String surName = isString();

        for (int i = 0; i < blackList.getBlackList().length; i++) {
            if (blackList.getBlackList()[i][1].equals(surName) && blackList.getBlackList()[i][0].equals(name)){
                System.out.println("This user is Black Listed, replay.. ");
                surName = "BlackListed";
            }
        }

        return surName;
    }

    public String countrySet(){
        boolean done = true;
        String country = "";

        while (done){
            done = false;
            country = isString();
            boolean inexistedCountry = true;

            for (int i = 0; i < countrySupport.getUnsupported().length; i++) {

                if (countrySupport.getUnsupported()[i].equals(country)){
                    System.out.println("This user is Unsupported Country try else :  ");
                    done = true;
                    break;
                }
            }
            for (int i = 0; i < countrySupport.getSupported().length; i++) {

                if (countrySupport.getSupported()[i].equals(country)){
                    inexistedCountry = false;
                }
            }

            if (inexistedCountry) {
                System.out.println("Inexistent Country, try again :");
                done = true;
            }
        }

        return country;
    }

    public Status statusSet(){
        int choice = -1;
        boolean done = true;

        while (done){
            done = false;

            System.out.println("Please choice Status\n" +
                    "1. New\n" +
                    "2. Waiting Approval\n" +
                    "3. InProgress\n" +
                    "4. Complete\n");

            choice = isDigit();
            if (choice == 1) status = Status.New;
            else if (choice == 2) status = Status.WaitingApproval;
            else if (choice == 3) status = Status.InProgress;
            else if (choice == 4) status = Status.Complete;
            else {
                System.out.println("Incorrect command, please try again");
                done = true;
            }
        }

        return status;
    }

    public double deliveryPriceSet(double price, String country){
        double deliveryPrice = price;

        for (int i = 0; i < countryList.getCountryList().size(); i++) {
            if (countryList.getCountryList().get(i).getName().equals(country)){
                double koeff = 1 + (double)countryList.getCountryList().get(i).getTaxFee()/100;
                deliveryPrice = price * koeff;
            }
        }

        return deliveryPrice;
    }

    public int id(List<Order> order){
        boolean done = true;
        int id = 0;

        while (done){
            done = false;
            id = isDigit();

            for (Order ord : order) {
                if (ord.getId() == id) {
                    System.out.println("ID is already exist please insert another");
                    done = true;
                }
            }
        }

        return id;
    }

}
