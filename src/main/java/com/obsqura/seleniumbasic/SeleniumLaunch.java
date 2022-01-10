package com.obsqura.seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SeleniumLaunch {
    static WebDriver driver;

    public static void testInitials(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\selenium driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\selenium\\selenium driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\selenium\\selenium driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            try {
                throw new Exception("Invalid browser name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void main(String args[]) {
        testInitials("Chrome");
        driver.get("http://demowebshop.tricentis.com/login");
       //String actualTitle =  driver.getTitle();
       //System.out.println(actualTitle);
       //String actualUrl = driver.getCurrentUrl();
        //System.out.println(actualUrl);
        //String pageSource = driver.getPageSource();
      //  System.out.println(pageSource);
        WebElement userName = driver.findElement(By.id("Email"));
        WebElement userName1 = driver.findElement(By.name("Email"));
        WebElement userName2 = driver.findElement(By.className("email"));
       WebElement userName3= driver.findElement(By.xpath("//*[@id=\"Email\"]"));
       WebElement userName4 = driver.findElement(By.cssSelector("#Email"));
        WebElement userName5 = driver.findElement(By.linkText("Log in"));
        WebElement userName6 = driver.findElement(By.partialLinkText("Log"));
        List<WebElement> tags = driver.findElements(By.tagName("input"));

        System.out.println(tags.size());
        System.out.println(userName5);
        System.out.println(userName6);




        System.out.println(userName);
        System.out.println(userName1);
        System.out.println(userName2);
       System.out.println(userName3);
        System.out.println(userName4);


        driver.close();
      //testInitials("Edge");
       // testInitials("Firefox");
    }
}