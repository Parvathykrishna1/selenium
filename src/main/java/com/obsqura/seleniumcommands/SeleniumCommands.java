package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
        String actlMessage = successfulMessage.getText();
        ;
        String expMessage = "Registration successful";
        //System.out.println(S);
        Assert.assertEquals(actlMessage, expMessage, "Error:Invalid message");

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
    public void verifyCommunityPoll() {
        driver.get("http://demowebshop.tricentis.com/");
        selectCommunityPoll("Good");
    }

    public void selectCommunityPoll(String poll) {
        List<WebElement> communityPoll = driver.findElements(By.xpath("//Li[@class='answer']/label"));
        for (int i = 0; i < communityPoll.size(); i++) {
            String value = communityPoll.get(i).getText();
            if (value.equals(poll)) {
                communityPoll.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 6)
    public void verifySingleInputField() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessage = driver.findElement(By.id("single-input-field"));
        enterMessage.sendKeys("Hello");
        WebElement showMessage = driver.findElement(By.id("button-one"));
        showMessage.click();
    }

    @Test(priority = 7)
    public void verifyTwoInputFields() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterValueA = driver.findElement(By.id("value-a"));
        enterValueA.sendKeys("Good");
        WebElement enterValueB = driver.findElement(By.id("value-b"));
        enterValueB.sendKeys("Morning");
        WebElement getTotal = driver.findElement(By.id("button-two"));
        getTotal.click();
    }

    @Test(priority = 8)
    public void verifySingleCheckboxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement clickOnThisCheckBox = driver.findElement(By.xpath("//label[@class='form-check-label']"));
        boolean notSelected = clickOnThisCheckBox.isSelected();
        System.out.println(notSelected);
        clickOnThisCheckBox.click();
        boolean selected = clickOnThisCheckBox.isSelected();
        System.out.println(selected);
    }

    @Test(priority = 9)
    public void verifyMultipleCheckboxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkBoxOne = driver.findElement(By.xpath("//label[@for='check-box-one']"));
        WebElement checkBoxThree = driver.findElement(By.xpath("//label[@for='check-box-three']"));
        boolean notSelected = checkBoxOne.isSelected();
        System.out.println(notSelected);
        checkBoxOne.click();
        checkBoxThree.click();
        boolean selected = checkBoxThree.isSelected();
        System.out.println(selected);
    }

    @Test(priority = 10)
    public void verifyRadioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        genderSelected("Male");
        WebElement showSelectedValue = driver.findElement(By.id("button-one"));
        showSelectedValue.click();
    }

    public void genderSelected(String gender) {
        List<WebElement> genderSelection = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//label"));
        for (int i = 0; i < genderSelection.size(); i++) {
            String value = genderSelection.get(i).getText();
            if (value.equals(gender)) {
                genderSelection.get(i).click();
                break;
            }

        }
    }

    @Test(priority = 11)
    public void verifyRadioButtonsDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        verifyGender("Male");
        verifyAge("19 t0 44");
        WebElement getResults = driver.findElement(By.id("button-two"));
        getResults.click();
    }


    public void verifyGender(String gender) {
        List<WebElement> genderSelection = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//label[@for='inlineRadio11']"));
        for (int i = 0; i < genderSelection.size(); i++) {
            String value = genderSelection.get(i).getText();
            if (value.equals(gender)) {
                genderSelection.get(i).click();
                break;
            }
        }
    }

    public void verifyAge(String age) {
        List<WebElement> ageSelection = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//label"));
        for (int i = 0; i < ageSelection.size(); i++) {
            String value = ageSelection.get(i).getText();
            if (value.equals(age)) {
                ageSelection.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 12)
    public void verifyDropDowns() {
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@href='register.php']"));
        registerMenu.click();
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(country);
        //select.selectByVisibleText("INDIA");
        //select.selectByValue("AMERICAN SAMOA");
        select.selectByIndex(2);
        List<String> expDropDownValue = new ArrayList<>();
        expDropDownValue.add("ALBANIA");
        expDropDownValue.add("ALGERIA");
        expDropDownValue.add("AMERICAN SAMOA");
        List<WebElement> dropDownObject = select.getOptions();
        List<String> actlDropDownValue = new ArrayList<>();
        for (int i = 0; i < dropDownObject.size(); i++) {
        actlDropDownValue.add(dropDownObject.get(i).getText());
        }
        System.out.println(actlDropDownValue.size());
        System.out.println(actlDropDownValue);
        Assert.assertEquals(actlDropDownValue,expDropDownValue,"Error:Invalid DropDown Data");

    }
}