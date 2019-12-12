package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestCases9_12 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        driver= BrowserFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on "Status Codes"
        driver.findElement(By.linkText("Status Codes")).click();


    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    /**
     * Test Case 9:
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. And click on “Status Codes”.
     Step 3. Then click on “200”.
     Step 4. Verify that following message is displayed:
     “This page returned a 200 status code”
     */
    @Test
    public void test9(){

        ArrayList<String> list= new ArrayList<>(Arrays.asList("200","301","404","500") );
        for(int i=0; i<list.size();i++) {
            //click on item
            driver.findElement(By.linkText(list.get(i))).click();
            //verify message
            String expected = "This page returned a " + list.get(i) + " status code";
            String actual = driver.findElement(By.xpath("//div/p")).getText();
            Assert.assertTrue(actual.startsWith(expected));
            driver.findElement(By.linkText("here")).click();
        }
    }




}
