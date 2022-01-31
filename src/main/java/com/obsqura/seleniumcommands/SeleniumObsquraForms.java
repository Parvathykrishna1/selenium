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

import java.util.List;

public class SeleniumObsquraForms {
    static WebDriver driver;

    public static void testInitials(String browser) {
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
    public void verifySingleInput() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement message = driver.findElement(By.id("single-input-field"));
        message.sendKeys("Hello World");
        WebElement showMessageButton = driver.findElement(By.id("button-one"));
        showMessageButton.click();
        boolean displayed = showMessageButton.isDisplayed();
        System.out.println(displayed);
        WebElement successMsg = driver.findElement(By.xpath("//div[@id='message-one']"));
        String v = successMsg.getText();
        System.out.println(v);
    }

    @Test(priority = 2)
    public void verifyTwoInput() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement valueA = driver.findElement(By.id("value-a"));
        valueA.sendKeys("Good");
        WebElement valueB = driver.findElement(By.id("value-b"));
        valueB.sendKeys("Morning");
        WebElement getTotal = driver.findElement(By.id("button-two"));
        getTotal.click();
        WebElement successMsg2 = driver.findElement(By.xpath("//div[@id='message-two']"));
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
        selectCheckbox("Check Box One", "Check Box Three");
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
    public void printTableData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(tableRows.size());
        for (int i = 1; i < tableRows.size(); i++) {
            List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='table1']//tr[" + i + "]//td"));
            String cellValue = tableColumns.get(0).getText();
            for (int j = 0; j < tableColumns.size(); j++) {
                System.out.println(tableColumns.get(j).getText());
            }
            System.out.println(i);
        }
    }


    @Test(priority = 7)
    public void printColumn() {
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        WebElement firstValue = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[1]"));
        System.out.println(firstValue.getText());

        List<WebElement> printCompanyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
        for (int i = 1; i < printCompanyNames.size(); i++) {
            System.out.println(printCompanyNames.get(i).getText());
        }

        List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
        List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
        for (int j = 0; j < companyNames.size(); j++) {
            if (companyNames.get(j).getText().equalsIgnoreCase("Nava Bharat Ventures")) {
                System.out.println(currentPrice.get(j).getText());
            }

            List<WebElement> printSecondRow = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[2]/td"));
            for (int k = 0; k < printSecondRow.size(); k++) {
                System.out.println(printSecondRow.get(k).getText());
            }
        }
    }
}
