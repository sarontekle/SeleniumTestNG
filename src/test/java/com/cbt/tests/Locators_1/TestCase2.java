package com.cbt.tests.Locators_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {
    /**
     go to amazon
     Go to ebay
     enter search term
     click on search button
     verify title contains search term
     */
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        WebElement srchItem=driver.findElement(By.id("twotabsearchtextbox"));
        srchItem.sendKeys("socks");
        Thread.sleep(1000);
        WebElement srchBtn=driver.findElement(By.xpath("//div/input"));
        srchBtn.click();
        Thread.sleep(1000);
        WebElement srchResult=driver.findElement(By.xpath("//h1/div/div/div/div"));
        String result=srchResult.getText();
        System.out.println(result.substring(13));
        Thread.sleep(1000);
        driver.quit();


    }
}
