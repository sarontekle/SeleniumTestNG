package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases1_5 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        driver= BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Enter “wrong_dob” into date of birth input box.
     Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on registration form
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        //enter "wrong_dob" on to birth input box
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        Thread.sleep(1000);
        //verify the warning message
        WebElement actual= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
       String actualResult= actual.getText();
        Assert.assertEquals(actualResult,"The date of birth is not valid");
    }

    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Verify that following options for programming languages are displayed:
     c++, java, JavaScript
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on registration form
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        //verify the options are displayed
        Thread.sleep(1000);
        WebElement option1=driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
         String one=option1.getText();
        WebElement option2=driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
         String two=option2.getText();
        WebElement option3= driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));
         String three=option3.getText();

       //Assertion
       Assert.assertEquals(one,"C++");
       Assert.assertEquals(two,"Java");
       Assert.assertEquals(three,"JavaScript");
    }

    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Enter only one alphabetic character into first name input box.
     Step 4. Verify that warning message is displayed:
     “first name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on registration form
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        //Enter only one alphabetic character into first name input box.
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("A");
        Thread.sleep(1500);
        //verify warning message
        WebElement message=driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        String warning=message.getText();
        String expected="first name must be more than 2 and less than 64 characters long";
        //Assertion
        Assert.assertEquals(warning, expected);
    }

}
