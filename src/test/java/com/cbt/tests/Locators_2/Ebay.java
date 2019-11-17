package com.cbt.tests.Locators_2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ebay {
    /**
     1. Open browser
     2. Go to https://ebay.com
     3. Search for wooden spoon
     4. Save the total number of results
     5. Click on link All
     6. Verify that number of results is bigger than the number in step 4
     7. Navigate back to previous research results page
     8. Verify that wooden spoon is displayed in the search box
     9. Navigate back to home page
     10. Verify that search box is blank
     */
    public static void main(String[] args) throws InterruptedException{
        //Open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //Go to https://ebay.com
        driver.get("https://www.ebay.com/");
        Thread.sleep(1000);
        //Search for wooden spoon
        WebElement srchItem= driver.findElement(By.xpath("//div/div/input"));
        srchItem.sendKeys("wooden spoon");
        Thread.sleep(1000);
        WebElement srchBtn=driver.findElement(By.id("gh-btn"));
        srchBtn.click();
        Thread.sleep(1000);
        //
        WebElement srchResult= driver.findElement(By.xpath("//h1/span"));
        String firstRslt=srchResult.getText();
        firstRslt=firstRslt.replace(",","");
        int Rslt1=Integer.parseInt(firstRslt);
        //Click on link All
        WebElement linkAll= driver.findElement(By.xpath("//li/a/span"));
        linkAll.click();
        //Verify that number of results is bigger than the number in step 4
        WebElement srchAll= driver.findElement(By.xpath("//div/h1/span"));
        String secondRslt=srchAll.getText();
        secondRslt=secondRslt.replace(",","");
        int Rslt2=Integer.parseInt(secondRslt);
        if(Rslt2>Rslt1){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("First result= "+Rslt1);
            System.out.println("Second result= "+Rslt2);
        }
        Thread.sleep(1000);
        //Navigate back to previous research results page
        driver.navigate().back();
        //Verify that wooden spoon is displayed in the search box
        WebElement srchItem2=driver.findElement(By.xpath("//input[@value='wooden spoon']"));
        String itmtxt=srchItem2.getText();
        String result= StringUtility.verfiyEquals(itmtxt,"wooden spoon");
        System.out.println(result);
        Thread.sleep(1000);
        //Navigate back to home page
        driver.navigate().back();
        //Verify that search box is blank
        WebElement srchItem3= driver.findElement(By.xpath("//div/div/input"));
        String result2=srchItem3.getText();
        if(result2.isEmpty()){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("result 2= "+result2);
        }
        Thread.sleep(1000);
        driver.quit();


    }
}
