package com.lifen.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest {
    WebDriver driver;
    @BeforeMethod
    public void  OpenChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
    }
//右击

    @Test
    public void RightClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement buttomBaidu =driver.findElement(By.id("su"));
        Actions action = new Actions(driver);
        action.contextClick(buttomBaidu).perform();
    }
    //双击
    @Test
    public void DoubleClickTest(){
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("sss");
        WebElement buttonBaidu =driver.findElement(By.id("su"));
        Actions action =new Actions(driver);
        action.doubleClick(buttonBaidu).perform();
    }

    @Test
    //有bug,写错的代码
    public void mouseMoveTest(){
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("sss");
        WebElement buttonBaidu =driver.findElement(By.id("su"));
        Actions action =new Actions(driver);
        action.doubleClick(buttonBaidu).perform();
        WebElement sssUrl = driver.findElement(By.partialLinkText("SSS_百度百科"));
      //  sssUrl.findElement(By.partialLinkText("SSS_百度百科"))
        action.moveToElement(sssUrl);
        String string = sssUrl.getText();
        System.out.println(string);
        Assert.assertEquals(string,"SSS_百度百科");
    }
    @Test
    public void DragAndDropTest(){
        driver.get("https://www.baidu.com/");
        WebElement element =driver.findElement(By.id("su"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(element,500,500).perform();
    }

    @AfterMethod
    public void QuitChrome() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }

}
