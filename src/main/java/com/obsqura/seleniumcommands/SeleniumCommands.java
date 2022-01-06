package com.obsqura.seleniumcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SeleniumCommands {
     WebDriver driver;

    public void testInitials(String browser) {
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
    @BeforeMethod
    public void setUp() {
        testInitials("Chrome");
    }
    @AfterMethod
    public void tearDone(){
        driver.close();
    }
    @Test(priority=1)
    public void verifyLogin(){
    driver.get("http://demowebshop.tricentis.com/");
    WebElement loginMenu= driver.findElement(By.xpath("//a[@class='ico-login']"));
    loginMenu.click();
    WebElement email = driver.findElement(By.id("Email"));
    email.sendKeys("parvathyk285@gamil.com");
    WebElement password= driver.findElement(By.cssSelector("#Password"));
    password.sendKeys("Password#1998");
    WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
    String value = loginButton.getAttribute("value");
    loginButton.click();

    }
}
