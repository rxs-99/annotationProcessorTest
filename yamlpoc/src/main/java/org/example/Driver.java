package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Driver {

    public String sol(List<String> list) {
        int[] a = new int[260];
        int currentMax = 0;
        String maxEle = null;
        for (String s: list) {
            if (s.charAt(0) == '+') {
                int index = ((s.charAt(1) - '0') * 26) + (s.charAt(2) - 'A');
                a[index]++;
                if (a[index] > currentMax) {
                    currentMax = a[index];
                    maxEle = s;
                }
                else if (a[index] == currentMax) {
                    if (index < currentMax) {
                        currentMax = a[index];
                        maxEle = s;
                    }
                }
            }
        }
        System.out.println(currentMax);
        return maxEle.substring(1);
    }

    public static void main( String[] args ) {
        List<String> list = Arrays.asList("+3E" + "-3E" + "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+3E", "-4F", "+4F", "-4F", "+4F", "+4F", "+4F");
        System.out.println(new Driver().sol(list));
    }
}
