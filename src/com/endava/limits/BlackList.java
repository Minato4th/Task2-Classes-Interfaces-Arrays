package com.endava.limits;

import java.util.Arrays;

/**
 * 3/21/2017
 */
public class BlackList {

    String[][] blackList;

    public BlackList() {
        this.blackList = new String [][] {
                {"Rahim", "Abdula"},
                {"Mad", "Max"},
                {"Jon", "Inesent" }};
    }

    public String[][] getBlackList() {
        return blackList;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "blackList=" + Arrays.toString(blackList) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlackList)) return false;

        BlackList blackList1 = (BlackList) o;

        return Arrays.deepEquals(getBlackList(), blackList1.getBlackList());

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(getBlackList());
    }
}
