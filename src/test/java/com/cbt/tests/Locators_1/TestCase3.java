package com.cbt.tests.Locators_1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    /**
     Go to wikipedia.org (Links to an external site.)
     enter search term `selenium webdriver`
     click on search button
     click on search result `Selenium (software)`
     verify url ends with `Selenium_(software)`
     */
    public static void main(String[] args) throws InterruptedException{
        //Go to wikipedia.org (Links to an external site.)
        WebDriver driver= BrowserFactory.getDriver("Chrome");
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(1000);
        //Enter search term `selenium webdriver`
        WebElement srchItem= driver.findElement(By.id("searchInput"));
        srchItem.sendKeys("selenium webdriver");
        Thread.sleep(1000);
        //Click on search button
        WebElement srchBtn=driver.findElement(By.xpath("//button/i"));
        srchBtn.click();
        Thread.sleep(1000);
        //click on search result `Selenium (software)`
        WebElement srchResult=driver.findElement(By.xpath("//li/div/a"));
        srchResult.click();
        //Verify url ends with `Selenium_(software)`
        String actualURL=driver.getCurrentUrl();
        String Ending="Selenium_(software)";
        if(actualURL.endsWith(Ending)){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
            System.out.println("Url= "+actualURL);
            System.out.println("Expected ending= "+Ending);
           }
        Thread.sleep(1000);
        driver.quit();

    }
}
