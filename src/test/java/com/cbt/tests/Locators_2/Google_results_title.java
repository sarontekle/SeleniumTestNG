package com.cbt.tests.Locators_2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Google_results_title {
    /**
     1. Open browser
     2. Go to https://google.com
     3. Search for one of the strings the list searchStrs given below
     4. In the results pages, capture the url right below the first results
     5. Click on the first result
     6. Verify that url is equal to the value from step 4
     7. Navigate back
     8. Repeat the same steps for all search items in the list
     List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium" );
     */
    public static void main(String[] args) throws InterruptedException{
        //open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //goto https://google.com
        driver.get("https://google.com");
        Thread.sleep(1000);
        //Search for one of the strings the list searchStrs given below
        ArrayList<String> searchStrs = new ArrayList<>(Arrays.asList("Java", "JUnit", "Selenium" ) );
        WebElement str1Element= driver.findElement(By.name("q"));
        str1Element.sendKeys(searchStrs.get(0));
        str1Element.submit();

        //In the results pages, capture the url right below the first results
        WebElement str1URL= driver.findElement(By.className("TbwUpd"));
        String firstURL= str1URL.getText();
        //System.out.println(firstURL);

        //Click on the first result
        WebElement firstResult= driver.findElement(By.className("LC20lb"));
        firstResult.click();

        //Verify that url is equal to the value from step 4
        String currentURL= driver.getCurrentUrl();
        String result= StringUtility.verfiyEquals(firstURL,currentURL);
        System.out.println(result);



    }
}
