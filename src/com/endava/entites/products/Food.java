package com.endava.entites.products;

/**
 * 3/21/2017
 */
public class Food extends Product implements ProductionProduct {

    @Override
    public String printInfo() {
        return getProductType() + getPrice() + getCountryToDeliver() + getCount() + getWeight() + getDeliveryPrice() + getStatus();
    }
}
