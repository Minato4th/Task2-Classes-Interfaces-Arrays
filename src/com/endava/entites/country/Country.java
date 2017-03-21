package com.endava.entites.country;

/**
 * 3/21/2017
 */
public class Country {

    String Name;
    int TaxFee;

    public Country(String name, int taxFee) {
        TaxFee = taxFee;
        Name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Name='" + Name + '\'' +
                ", TaxFee=" + TaxFee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (TaxFee != country.TaxFee) return false;
        return Name != null ? Name.equals(country.Name) : country.Name == null;

    }

    @Override
    public int hashCode() {
        int result = Name != null ? Name.hashCode() : 0;
        result = 31 * result + TaxFee;
        return result;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTaxFee() {
        return TaxFee;
    }

    public void setTaxFee(int taxFee) {
        TaxFee = taxFee;
    }
}
