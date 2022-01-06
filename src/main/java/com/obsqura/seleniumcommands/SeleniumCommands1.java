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

public class SeleniumCommands1 {
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
    @Test(priority=2)
    public void registration(){
    driver.get("http://demowebshop.tricentis.com/");
    WebElement registerMenu= driver.findElement(By.xpath("//a[@class='ico-register']"));
    registerMenu.click();
    WebElement gender = driver.findElement(By.xpath("//input[@name='Gender']"));
    gender.click();
    WebElement firstName = driver.findElement(By.id("FirstName"));
    firstName.sendKeys("parvathy");
    WebElement lastName = driver.findElement(By.id("LastName"));
    lastName.sendKeys("krishna");
    WebElement email = driver.findElement(By.id("Email"));
    email.sendKeys("parvathyk285@gmail.com");
    WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
    password.sendKeys("Parvathy#1998");
    WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
    confirmPassword.sendKeys("Parvathy#1998");
    WebElement registerButton = driver.findElement(By.id("register-button"));
    registerButton.click();
    WebElement successfulMessage = driver.findElement(By.id("register-button"));
    successfulMessage.getText();
    }
}
