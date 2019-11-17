package com.cbt.tests.Locators_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShortcutFunctionality {
    /**
     1. Open browser
     2. Go to Vytrack login page
     3. Login as a sales manager
     4. Verify Dashboard page is open
     5. Click on Shortcuts icon
     6. Click on link See full list
     7. Click on link Opportunities
     8. Verify Open opportunities page is open
     9. Click on Shortcuts icon
     10.Click on link See full list
     11.Click on link Vehicle Service Logs
     12.Verify error message text is You do not have permission to perform this action.
     13.Verify Shortcut Actions List page is still open
     */
    public static void main(String[] args) throws InterruptedException {
        //Open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //Go to Vytrack login page
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(1000);
        //Login as a sales manager
        WebElement User= driver.findElement(By.id("prependedInput"));
        User.sendKeys("salesmanager119");
        Thread.sleep(1000);
        WebElement Pass= driver.findElement(By.id("prependedInput2"));
        Pass.sendKeys("UserUser123");
        Thread.sleep(1000);
        WebElement Login=driver.findElement(By.id("_submit"));
        Login.click();
        //Verify Dashboard page is open
        WebElement dshBrd= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        String actualPage=dshBrd.getText();
        if(actualPage.equalsIgnoreCase("Dashboard")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual page= "+actualPage);
        }
        //Click on Shortcuts icon
        WebElement shrtCt=driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a"));
        shrtCt.click();

        //Click on link See full list
        WebElement linkSeeFull= driver.findElement(By.linkText("See full list"));
        linkSeeFull.click();


    }
}
