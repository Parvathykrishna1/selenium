package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class SeleniumCommands {
    WebDriver driver;

    public void testInitials(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\selenium driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\selenium\\selenium driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
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
    public void tearDone() {
        driver.close();
    }

    @Test(priority = 1)

    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("parvathyk285@gmail.com");
        //email.clear();
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("Password#1998");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        String value = loginButton.getAttribute("value");
        System.out.println(value);
        String T = loginButton.getTagName();
        System.out.println(T);
        Point location = loginButton.getLocation();
        System.out.println(location.x);
        Dimension size = loginButton.getSize();
        System.out.println(size.width);
        boolean enableStatus = loginButton.isEnabled();
        System.out.println(enableStatus);
        boolean displayedStatus = loginButton.isDisplayed();
        System.out.println(displayedStatus);
        loginButton.click();
    }

    @Test(priority = 2)

    public void registration() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        WebElement gender = driver.findElement(By.xpath("//input[@name='Gender']"));
        //gender.click();
        boolean notSelected = gender.isSelected();
        System.out.println(notSelected);
        gender.click();
        boolean selected = gender.isSelected();
        System.out.println(selected);
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
        WebElement successfulMessage = driver.findElement(By.xpath("//div[@class='result']"));
        String S = successfulMessage.getText();
        System.out.println(S);
    }

    @Test(priority = 3)
    public void verifyFindElements() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        selectGender("Female");
    }

    public void selectGender(String gender) {
        List<WebElement> genderSelection = driver.findElements(By.xpath("//label[@class='forcheckbox']"));
        for (int i = 0; i < genderSelection.size(); i++) {
            String value = genderSelection.get(i).getText();
            if (value.equals(gender)) {
                genderSelection.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 4)
    public void verifyNavigationCommands() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
    }

    @Test(priority = 5)
    public void verifyCommunityPole() {
        driver.get("http://demowebshop.tricentis.com/");
        communityPoll("Good");
    }
    public void communityPoll(String poll){
        List<WebElement> communityPoll = driver.findElements(By.xpath("//Li[@class='answer']"));
        for(int i=0;i<communityPoll.size();i++){
            String value = communityPoll.get(i).getText();
            if(value.equals(poll))
            {
                communityPoll.get(i).click();
                break;}
        }
    }
}

