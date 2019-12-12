package com.cbt.tests.TestCases_3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestCases1_6 {
    WebDriver driver;
    ChromeDriver driver2= new ChromeDriver();
    @BeforeMethod
    public void setupMethod(){

        driver= BrowserFactory.getDriver("chrome");
//        driver.navigate().refresh();



    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    /**
     comments here
     */
}
