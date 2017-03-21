package com.endava.entites.country;

import java.util.ArrayList;
import java.util.List;

/**
 * 3/21/2017
 */
public class CountryList {
    private List<Country> countryList = new ArrayList<>();

    public CountryList() {
        this.countryList.add(new Country("Moldova", 15));
        this.countryList.add(new Country("Ukraine", 10));
        this.countryList.add(new Country("Romania", 5));
    }

    @Override
    public String toString() {
        return "CountryList{" +
                "countryList=" + countryList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryList)) return false;

        CountryList that = (CountryList) o;

        return getCountryList() != null ? getCountryList().equals(that.getCountryList()) : that.getCountryList() == null;

    }

    @Override
    public int hashCode() {
        return getCountryList() != null ? getCountryList().hashCode() : 0;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
