package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {
    /**
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. And click on “File Upload".
     Step 3. Upload any file with .txt extension from your computer.
     Step 4. Click “Upload” button.
     Step 5. Verify that subject is: “File Uploaded!”
     Step 6. Verify that uploaded file name is displayed.
     Note: use element.sendKeys(“/file/path”) with specifying path
     to the file for uploading. Run this method against “Choose File” button.
     */
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
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //click on "File upload"
        driver.findElement(By.linkText("File Upload")).click();
        //upload file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\welbe\\Desktop\\Saron's.txt");
        //Thread.sleep(1000);
        driver.findElement(By.id("file-submit")).click();
        //verify subject
        String expected="File Uploaded!";
        String actual=driver.findElement(By.xpath("//div/h3")).getText();

        Assert.assertEquals(actual,expected);
        //verify the file name
        String expected2="Saron's.txt";
        String actual2=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual2,expected2);
    }
}
