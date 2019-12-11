package com.lifen.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegisterTest<test> {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://mail.163.com/");
    }
@Test
    public void register() throws InterruptedException {
        //q切换控制权

        driver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        Thread.sleep(3000);
        //找到注册元素
       // driver.findElement(By.xpath("//*[@id=\"changepage\"]"));
        //获取当前driver所在的handle值
        String handle1 = driver.getWindowHandle();
        //切换到薪的window界面
        for (String handles : driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time =String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("username")).sendKeys("a"+ time);
        Thread.sleep(3000);

}
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
