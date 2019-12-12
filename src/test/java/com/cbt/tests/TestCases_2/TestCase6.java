package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {
    /**
     Step 1. Go to "https://www.tempmailaddress.com/"
     Step 2. Copy and save email as a string.
     Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     Step 4. And click on “Sign Up For Mailing List".
     Step 5. Enter any valid name.
     Step 6. Enter email from the Step 2.
     Step 7. Click Sign Up
     Step 8. Verify that following message is displayed:
     “Thank you for signing up. Click the button below to return to the home page.”
     Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     Step 10. Verify that you’ve received an email from
     “do-not-reply@practice.cybertekschool.com”
     Step 11. Click on that email to open it.
     Step 12. Verify that email is from:
     “do-not-reply@practice.cybertekschool.com”
     Step 13. Verify that subject is:
     “Thanks for subscribing to practice.cybertekschool.com!”
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
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        //copy and save email as string
        WebElement email=driver.findElement(By.id("email"));
        String Email= email.getText();
        //System.out.println(Email);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //sign up for mailing list
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        //enter any valid name
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Saron");
        //enter email from step 2
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
        //Thread.sleep(1000);
        //click sign up
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        //verify message
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message=driver.findElement(By.xpath("//div/h3"));
        String actual=message.getText();
        //Assertion
        Assert.assertEquals(actual,expected);

        //navigate back
        driver.navigate().back();
        //verify email is received
        driver.findElement(By.xpath("//tbody/tr[3]")).click();

    }
}
