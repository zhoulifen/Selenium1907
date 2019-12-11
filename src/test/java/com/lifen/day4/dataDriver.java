package com.lifen.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDriver {
    @DataProvider(name="loginUser")
    public Object[][] data1(){
        return new Object[][]{{"user1","pwd1"},
                {"user2","pwd2"}};
    }
    @Test(dataProvider="loginUser")
    public void loginTest(String user,String pwd){
        System.out.println("user"+user);
        System.out.println("pwd"+pwd);
    }
}
