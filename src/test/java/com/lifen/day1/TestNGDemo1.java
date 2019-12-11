package com.lifen.day1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @BeforeTest
    public void BeforeTest01(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("这是BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("z这是@test注解");
    }
    @Test
    public void testCase2(){
        System.out.println("这是注解2");
    }
}
