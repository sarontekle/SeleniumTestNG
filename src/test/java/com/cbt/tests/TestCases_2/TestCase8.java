package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {
    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. And click on “Autocomplete”.
     Step 3. Enter “United States of America” into country input box.
     Step 4. Verify that following message is displayed:
     “You selected: United States of America”
     */
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        driver= BrowserFactory.getDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on Autocomplete
        driver.findElement(By.linkText("Autocomplete")).click();
        //enter text
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        //verify message
        String expected="You selected: United States of America";
        String actual=driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actual,expected);

    }

}
