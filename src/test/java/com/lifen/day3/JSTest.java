package com.lifen.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
 WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void citeJS(){
    driver.get("https://www.baidu.com/");
        JavascriptExecutor is = (JavascriptExecutor)driver;

            }
}
