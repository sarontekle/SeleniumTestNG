package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TtitleVerification {

    public static void main(String[] args) throws InterruptedException{
        ArrayList<String> urls= new ArrayList<>(Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login"));
        WebDriver driver= BrowserFactory.getDriver("chrome");
//        #1 url
        driver.get("http://practice.cybertekschool.com/");
        String title1= driver.getTitle();
        String url1= driver.getCurrentUrl();
        Thread.sleep(2000);

//        #2 url
        driver.get("http://practice.cybertekschool.com/dropdown");
        String title2=driver.getTitle();
        String url2= driver.getCurrentUrl();
        Thread.sleep(2000);

//        #3 url
        driver.get("http://practice.cybertekschool.com/login");
        String title3= driver.getTitle();
        String url3=driver.getCurrentUrl();
        Thread.sleep(2000);

        driver.quit();

        if( title1.equals(title2) && title1.equals(title3) ){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("Title 1= "+title1);
            System.out.println("Title 2= "+title2);
            System.out.println("Title 3= "+title3);

        }
        if( url2.startsWith(url1) && url3.startsWith(url1) ){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("Url 1= "+url1);
            System.out.println("Url 2= "+url2);
            System.out.println("Url 3= "+url3);

        }





    }
}
