package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification2 {
    public static void main(String[] args) throws InterruptedException{
        ArrayList<String> urls= new ArrayList<>(Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https://westelm.com/"));
        for( int i=0; i<urls.size(); i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            Thread.sleep(1000);
            driver.get(urls.get(i));
            String titleOfAdd = driver.getTitle().toLowerCase().replace("\\s", "");
            String urlOfAdd = driver.getCurrentUrl();
            Thread.sleep(1000);
            if (urlOfAdd.contains(titleOfAdd)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("Title= " + titleOfAdd);
                System.out.println("Url= " + urlOfAdd);
            }
            driver.quit();

        }



    }
}
