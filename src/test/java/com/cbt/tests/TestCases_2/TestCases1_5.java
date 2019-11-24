package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

    /**
     Step 1. Go to https://practice-cybertekschool.herokuapp.com
     Step 2. Click on “Registration Form”
     Step 3. Enter only one alphabetic character into last name input box.
     Step 4. Verify that warning message is displayed:
     “The last name must be more than 2 and less than 64 characters long”
     */

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on registration form
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        //Enter only one alphabetic character into last name input box.
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A");
        //verify warning message
        WebElement warning= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        String actual=warning.getText();
        String expected="The last name must be more than 2 and less than 64 characters long";
        //Assertion
        Assert.assertEquals(actual,expected);
    }

    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Enter any valid first name.
     Step 4. Enter any valid last name.
     Step 5. Enter any valid user name.
     Step 6. Enter any valid password.
     Step 7. Enter any valid phone number.
     Step 8. Select gender.
     Step 9. Enter any valid date of birth.
     Step 10. Select any department.
     Step 11. Enter any job title.
     Step 12. Select java as a programming language.
     Step 13. Click Sign up.
     Step 14. Verify that following success message is displayed:
     “You've successfully completed registration!”
     */
  @Test
    public void test5() throws InterruptedException {
      driver.get("https://practice-cybertekschool.herokuapp.com");
      //click on registration form
      driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
      //enter any valid first name
      driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Saron");
      //enter any valid last name
      Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Tekle");
      //enter any valid user name
      Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saronyohannes");
      /**
       //enter valid email address
       driver.findElement(By.xpath("//input[@name='email']")).sendKeys("saronyohannes.sy@yahoo.com");
       Thread.sleep(1000);
       */

      //enter any valid password
      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lid2Habtom");
      Thread.sleep(1000);
      //enter any valid phone number
      driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("202-725-4302");
      Thread.sleep(1000);
      //select gender
      driver.findElement(By.xpath("//input[@value='female']")).click();
      Thread.sleep(1000);
      //enter any valid date of birth
      driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("06/16/1995");
      //select any department
      WebElement department= driver.findElement(By.xpath("//select"));
      department.click();
      Select select= new Select(department);
      select.selectByValue("DE");
      //enter any job title
      WebElement job=driver.findElement(By.xpath("//select[@name='job_title']"));
      job.click();
      Select select1= new Select(job);
      select1.selectByIndex(4);
//      Thread.sleep(1000);
      //select java as programming language
      driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
      //click sign in
      driver.findElement(By.cssSelector("#wooden_spoon")).click();
      //Thread.sleep(3000);

      //Verify message
      WebElement message=driver.findElement(By.xpath("//div/p"));
      String actual=message.getText();
      String expected="You've successfully completed registration!";
      //Assertion
      Assert.assertEquals(actual,expected);

  }
}
