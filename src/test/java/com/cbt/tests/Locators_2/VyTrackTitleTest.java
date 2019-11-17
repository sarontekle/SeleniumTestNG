package com.cbt.tests.Locators_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class VyTrackTitleTest {
    /**
     1. Open browser
     2. Go to Vytrack login page
     3. Login as any user
     4. Click on your name on top right
     5. Click on  My Conﬁguration
     6. Verify that title start with the same name on top right
     */
    public static void main(String[] args) throws InterruptedException{
        //Open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //Go to Vytrack login page
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(1000);
        //Login as any user
        WebElement User= driver.findElement(By.id("prependedInput"));
        User.sendKeys("user19");
        Thread.sleep(1000);
        WebElement Pass=driver.findElement(By.id("prependedInput2"));
        Pass.sendKeys("UserUser123");
        Thread.sleep(1000);
        WebElement loginBtn=driver.findElement(By.xpath("//div/button"));
        loginBtn.click();
        //Click on your name on top right
        WebElement name=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));
        name.click();
        String dropdownName=name.getText();
        Thread.sleep(1000);
        //Click on  My Conﬁguration
        WebElement Myconfig=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a"));
        Myconfig.click();
        String title=driver.getTitle();
        //Verify that title start with the same name on top right
        if(title.startsWith(dropdownName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Title= "+title);
            System.out.println("Name= "+dropdownName);
        }
        //Thread.sleep(1000);
        //driver.quit();



    }
}
