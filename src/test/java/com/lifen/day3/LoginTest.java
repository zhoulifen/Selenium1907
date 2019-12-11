package com.lifen.day3;

import com.PO.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://mail.qq.com/");
    }
    @Test
    public void loginSuccess1() throws InterruptedException {
        driver.switchTo().frame("login_frame");
        driver.findElement(LoginPage.emailInput).sendKeys( "1174452872");
        driver.findElement(LoginPage.emailpwd).sendKeys("zlf11223344");
        driver.findElement(LoginPage.LoginButton).click();
        Thread.sleep(3000);
    }
    @Test
    public void loginFail() throws InterruptedException {
        driver.switchTo().frame("login_frame");
        driver.findElement(By.cssSelector("#u")).sendKeys("1174452872");
        driver.findElement(By.id("p")).sendKeys("zlf11223");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(2000);
        String sssUrl = driver.findElement(By.id("err_m")).getText();
        Assert.assertEquals(sssUrl,"你输入的帐号或密码不正确，请重新输入。");
        Thread.sleep(3000);
    }
    @Test
    public void sendEmail() throws InterruptedException {
        driver.switchTo().frame("login_frame");
        driver.findElement(By.cssSelector("#u")).sendKeys("1174452872");
        driver.findElement(By.id("p")).sendKeys("zlf11223344");
        driver.findElement(By.id("login_button")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
