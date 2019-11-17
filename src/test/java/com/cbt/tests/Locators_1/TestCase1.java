package com.cbt.tests.Locators_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    /**
     Go to ebay
     enter search term
     click on search button
     print number of results
     */
    public static void main(String[] args) throws InterruptedException{
        //Go to ebay
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        Thread.sleep(1000);

        //Enter search term
        WebElement searchItem= driver.findElement(By.xpath("/html/body/header/table/tbody/tr/td/form/table/tbody/tr/td/div/div/input"));
        searchItem.sendKeys("socks");
        WebElement searchBtn=driver.findElement(By.id("gh-btn"));
        searchBtn.click();
        Thread.sleep(1000);
        WebElement searchResult=driver.findElement(By.xpath("//div/h1"));
        String result=searchResult.getText();
        System.out.println(result);
        Thread.sleep(1000);
        driver.quit();



    }
}
