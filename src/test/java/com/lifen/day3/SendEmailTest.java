package com.lifen.day3;

import com.PO.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.qq.com/");
    }
@Test
public void sendEmailTestCase() throws InterruptedException {
   //     SendEmailTest.openChrome();
    SendEmailTest.loginSuccess(driver,"1174452872","zlf11223344");
//    SendEmailTest.closed(driver);
    }

    @Test
    public static void loginSuccess(WebDriver driver, String userName, String passward) throws InterruptedException {
         driver.switchTo().frame("login_frame");
        driver.findElement(LoginPage.emailInput).sendKeys(userName);
        driver.findElement(LoginPage.emailpwd).sendKeys(passward);
        driver.findElement(LoginPage.LoginButton).click();
        Thread.sleep(3000);
    }
    @AfterMethod
    public static void closed(WebDriver driver){
        driver.quit();
    }
}
