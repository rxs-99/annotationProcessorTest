package org.example;

import org.testng.annotations.Test;

public class test1 extends Base {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void test() {
        System.out.println("Testing 1234");
    }
}
