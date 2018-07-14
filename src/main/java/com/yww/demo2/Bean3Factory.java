package com.yww.demo2;

/**
 * Bean3的实例工厂
 */
public class Bean3Factory {
    public Bean3 createBean3() {

        System.out.println("Bean3Factory....");
        return new Bean3();
    }
}
