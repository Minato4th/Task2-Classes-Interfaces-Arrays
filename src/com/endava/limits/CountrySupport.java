package com.endava.limits;

import java.util.Arrays;

/**
 * 3/21/2017
 */
public class CountrySupport {
    String[] supported;
    String[] unsupported;

    public CountrySupport() {
        this.supported = new String[]{"Moldova", "Ukraine", "Romania", "Belarus", "Russia"};
        this.unsupported = new String [] {"Australia", "Japan", "Argentina"};
    }

    @Override
    public String toString() {
        return "CountrySupport{" +
                "supported=" + Arrays.toString(supported) +
                ", unsupported=" + Arrays.toString(unsupported) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountrySupport)) return false;

        CountrySupport that = (CountrySupport) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getSupported(), that.getSupported())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getUnsupported(), that.getUnsupported());

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getSupported());
        result = 31 * result + Arrays.hashCode(getUnsupported());
        return result;
    }

    public String[] getSupported() {
        return supported;
    }

    public String[] getUnsupported() {
        return unsupported;
    }
}
