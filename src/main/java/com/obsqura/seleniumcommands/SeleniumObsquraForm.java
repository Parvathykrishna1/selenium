package com.obsqura.seleniumcommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumObsquraForm {
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

    public void tearDone() {
        driver.close();
    }


    @Test(priority = 1)
    public void verifyInputForm() {
        driver.get("https://selenium.obsqurazone.com/index.php");
        WebElement inputForm = driver.findElement(By.xpath("//a[@href='simple-form-demo.php']"));
        inputForm.click();
        WebElement messageField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
        messageField.sendKeys("testing obsqura form");
        WebElement showButton = driver.findElement(By.xpath("//button[@id='button-one']"));
        showButton.click();
        WebElement successMsg = driver.findElement(By.xpath("//div[@id='message-one']"));
        String v = successMsg.getText();
        System.out.println(v);
        WebElement valueAfield = driver.findElement(By.id("value-a"));
        valueAfield.sendKeys("100");
        WebElement valueBfield = driver.findElement(By.id("value-b"));
        valueBfield.sendKeys("500");
        WebElement getTotal = driver.findElement(By.id("button-two"));
        getTotal.click();
        WebElement successMsg2 = driver.findElement(By.id("message-two"));
        String v2 = successMsg2.getText();
        System.out.println(v2);
    }

    @Test(priority = 2)
    public void verifySingleCheckboxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement box = driver.findElement(By.id("gridCheck"));
        box.click();
        WebElement grid = driver.findElement(By.xpath("//input[@id='gridCheck']/following-sibling::label"));
        grid.click();
        boolean selectionCheckbox = box.isDisplayed();
        System.out.println(selectionCheckbox);
        WebElement singleSuccessMsg = driver.findElement(By.id("message-one"));
        String v3 = singleSuccessMsg.getText();
        System.out.println(v3);
    }

    @Test(priority = 3)
    public void verifyMultipleCheckbox() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement box = driver.findElement(By.id("gridCheck"));
        box.click();
        selectCheckbox("Check Box One", "Check Box Two");

    }

    public void selectCheckbox(String value1, String value2) {
        List<WebElement> Checkbox = driver.findElements(By.xpath("//input[@class='check-box-list']/following-sibling::label"));
        //System.out.println("total number of checkbox"+checkbox.size());
        for (int i = 0; i < Checkbox.size(); i++) {
            String values = Checkbox.get(i).getText();
            if (values.equals(value1)) {
                Checkbox.get(i).click();
            }
            if (values.equals(value2)) {
                Checkbox.get(i).click();
            }


        }

    }

    @Test(priority = 4)
    public void verifyRadioButtons() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement radioButtonDemo = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        radioButtonDemo.click();
        WebElement buttonClick = driver.findElement(By.id("button-one"));
        buttonClick.click();
        WebElement showMsg = driver.findElement(By.id("message-one"));
        System.out.println(showMsg.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyGroupRadioButtons() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement patientGender = driver.findElement(By.id("inlineRadio11"));
        patientGender.click();
        WebElement patientAge = driver.findElement(By.id("inlineRadio23"));
        patientAge.click();
        WebElement buttonPatient = driver.findElement(By.id("button-two"));
        buttonPatient.isSelected();
        buttonPatient.click();
        WebElement showPatientMsg = driver.findElement(By.id("message-two"));
        String msgs = showPatientMsg.getText();
        System.out.println(msgs);
    }

    @Test(priority = 6)
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload");
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\ravat\\Downloads\\Parvathykrishna-Assignment.doc");
        WebElement chkBoxAcceptFile = driver.findElement(By.xpath("//input[@id='terms']"));
        chkBoxAcceptFile.click();
        WebElement btnSubmitFile = driver.findElement(By.id("submitbutton"));
        btnSubmitFile.click();
    }

    @Test(priority = 7)
    public void verifySimpleAlert() {
        driver.get(" https://demoqa.com/alerts");
        WebElement btnClickMe = driver.findElement(By.id("alertButton"));
        btnClickMe.click();
        Alert alert = driver.switchTo().alert();
        String actAlertTxt = alert.getText();
        System.out.println(actAlertTxt);
        alert.accept();
    }

    @Test(priority = 8)
    public void verifyConfirmationAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement btnConfrm = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        btnConfrm.click();
        Alert alert = driver.switchTo().alert();
        String actAlertText = alert.getText();
        System.out.println(actAlertText);
        alert.accept();
        //alert.dismiss();
        WebElement confirmText = driver.findElement(By.id("confirmResult"));
        String cText = confirmText.getText();
        System.out.println(cText);
    }

    @Test(priority = 9)
    public void verifyPromptAlert() {

        driver.get("https://demoqa.com/alerts");
        WebElement btnPromptAlert = driver.findElement(By.id("promtButton"));
        btnPromptAlert.click();
        Alert alert = driver.switchTo().alert();
        String actAlertTxt = alert.getText();
        System.out.println(actAlertTxt);
        alert.sendKeys("raj");
        alert.accept();
    }
}


