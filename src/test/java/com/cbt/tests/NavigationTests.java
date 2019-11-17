package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    /**
     * 1. Open  browser
     * 2. Go    to  website https://google.com
     * 3. Save the  title in    a   string  variable
     * 4. Go    to  https://etsy.com
     * 5. Save the  title   in  a   string  variable
     * 6. Navigate  back    to  previous page
     * 7. Verify    that    title   is  same    is  in  step    3
     * 8. Navigate  forward to  previous    page
     * 9. Verify    that    title   is  same    is  in  step    5
     */
    public static void main(String[] args) {
        Chrome();
        Edge();
        Firefox();
    }
    public static void Chrome(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //Go    to  website https://google.com
        driver.get("https://google.com");
        //Save the  title in    a   string  variable
        String title1= driver.getTitle();
        //Go    to  https://etsy.com
        driver.get("https://etsy.com");
        //Save the  title   in  a   string  variable
        String title2= driver.getTitle();
        //Navigate  back    to  previous page
        driver.navigate().back();
        //Verify    that    title   is  same    is  in  step    3
        String title3=driver.getTitle();
        String result=StringUtility.verfiyEquals(title1, title3);
        System.out.println("Chrome"+ result);
        //Navigate  forward to  previous page
        driver.navigate().forward();
        //Verify    that    title   is  same is in  step    5
        String title4=driver.getTitle();
        String result2= StringUtility.verfiyEquals(title2, title4);
        System.out.println("Chrome"+result2);
        //close the browser
        driver.quit();
    }
    public static void Edge(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("Edge");
        //Go    to  website https://google.com
        driver.get("https://google.com");
        //Save the  title in    a   string  variable
        String title1= driver.getTitle();
        //Go    to  https://etsy.com
        driver.get("https://etsy.com");
        //Save the  title   in  a   string  variable
        String title2= driver.getTitle();
        //Navigate  back    to  previous page
        driver.navigate().back();
        //Verify    that    title   is  same    is  in  step    3
        String title3=driver.getTitle();
        String result= StringUtility.verfiyEquals(title1, title3);
        System.out.println("Edge"+result);
        //Navigate  forward to  previous page
        driver.navigate().forward();
        //Verify    that    title   is  same is in  step    5
        String title4=driver.getTitle();
        String result2= StringUtility.verfiyEquals(title2, title4);
        System.out.println("Edge"+result2);
        //close the browser
        driver.quit();
    }
    public static void Firefox(){
        //open browser
        WebDriver driver= BrowserFactory.getDriver("firefox");
        //Go    to  website https://google.com
        driver.get("https://google.com");
        //Save the  title in    a   string  variable
        String title1= driver.getTitle();
        //Go    to  https://etsy.com
        driver.get("https://etsy.com");
        //Save the  title   in  a   string  variable
        String title2= driver.getTitle();
        //Navigate  back    to  previous page
        driver.navigate().back();
        //Verify    that    title   is  same    is  in  step    3
        String title3=driver.getTitle();
        String result= StringUtility.verfiyEquals(title1, title3);
        System.out.println("Firefox"+result);
        //Navigate  forward to  previous page
        driver.navigate().forward();
        //Verify    that    title   is  same is in  step    5
        String title4=driver.getTitle();
        String result2= StringUtility.verfiyEquals(title2, title4);
        System.out.println("Firefox"+result2);
        //close the browser
        driver.quit();

    }



}
