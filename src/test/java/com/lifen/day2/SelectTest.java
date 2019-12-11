package com.lifen.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void  OpenChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        //全局等待
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * 打开测试界面
     * 下拉框选择1
     * 第二次选择2
     * 第三次选择3
     */
    @Test
    public void SelectTest(){
        driver.get("");
        WebElement selectE1 =driver.findElement(By.id(""));
        Select select = new Select(selectE1);
        select.selectByIndex(2);
        select.selectByValue("huawei");
        select.selectByVisibleText("iphone");

    }
    /*
    打开百度界面
    找到输入框，输入人性的弱点
    点击百度一下
    在新界面点击第一条链接
    在新页面点击按钮
     */
    @Test
    public void TestWin() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("人性的弱点");
        driver.findElement(By.id("su")).click();
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
      //  Thread.sleep(3000);
//
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"1\"]/h3/a")));
        driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a")).click();
//句柄转换
       String currentHandle = driver.getWindowHandle();
       for(String handles : driver.getWindowHandles()){
           if(handles.equals(currentHandle)){
               continue;
           }else {
               driver.switchTo().window(handles);
           }
       }
     //   String Url2 = driver.getCurrentUrl();
        //System.out.println(Url2);
        driver.findElement(By.linkText("编辑推荐")).click();
    }



   @AfterMethod
     public void QuitChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
