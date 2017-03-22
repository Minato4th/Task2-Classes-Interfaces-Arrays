package com.endava.entites.products;

/**
 * 3/21/2017
 */
public abstract class Product {

    String productType;
    double price;
    String countryToDeliver;
    int count;
    int weight;
    double deliveryPrice;
    Status status;

    @Override
    public String toString() {
        return "Product{" +
                "productType='" + productType + '\'' +
                ", price=" + price +
                ", countryToDeliver='" + countryToDeliver + '\'' +
                ", count=" + count +
                ", weight=" + weight +
                ", deliveryPrice=" + deliveryPrice +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getPrice() != product.getPrice()) return false;
        if (getCount() != product.getCount()) return false;
        if (getWeight() != product.getWeight()) return false;
        if (getDeliveryPrice() != product.getDeliveryPrice()) return false;
        if (getProductType() != null ? !getProductType().equals(product.getProductType()) : product.getProductType() != null)
            return false;
        if (getCountryToDeliver() != null ? !getCountryToDeliver().equals(product.getCountryToDeliver()) : product.getCountryToDeliver() != null)
            return false;
        return getStatus() == product.getStatus();

    }

    @Override
    public int hashCode() {

        int result;
        long temp;
        result = getProductType() != null ? getProductType().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getCountryToDeliver() != null ? getCountryToDeliver().hashCode() : 0);
        result = 31 * result + getCount();
        result = 31 * result + getWeight();
        temp = Double.doubleToLongBits(getDeliveryPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountryToDeliver() {
        return countryToDeliver;
    }

    public void setCountryToDeliver(String countryToDeliver) {
        this.countryToDeliver = countryToDeliver;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
