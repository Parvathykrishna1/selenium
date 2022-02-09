package com.obsqura.testngbasis;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestNGCommands {
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
    @Parameters({"browser", "url"})
    public void setUp(String browserName, String baseUrl) {
        testInitials(browserName);
        driver.get(baseUrl);
    }

    @AfterMethod
     public void tearDone(){
   /* public void tearDone(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
        }*/
        driver.close();
    }


    @Test(priority = 1,dataProvider = "UserCredentials")
    public void verifyLogin(String uname,String pword) {
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(uname);
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys(pword);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
    }
    @DataProvider(name="UserCredentials")
    public Object[][] userCredentialData(){
        Object data[][]=new Object[2][2];
        data[0][0]="parvathyk285@gmail.com";
        data[0][1]="parvathk1998@gmail.com";
        data[1][0]="minnu123@gmail.com";
        data[1][1]="user123@gmail.com";
        return data;
    }


    @Test(priority = 2)
    public void verifyLoginFromExcel() throws IOException, InterruptedException {
        List<String> excelList = new ArrayList<String>();
        ExcelUtility excel = new ExcelUtility();
        String excelPath = "\\src\\main\\resources\\readData.xlsx";
        String excelSheetName = "data";

        excelList = excel.readDataFromExcel(excelPath, excelSheetName);
        for(int i=0;i<excelList.size();i++) {
            System.out.println(excelList.get(i));
            WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
            loginMenu.click();
            driver.findElement(By.id("Email")).sendKeys(excelList.get(i));
            driver.findElement(By.cssSelector("#Password")).sendKeys(excelList.get(i+1));
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
            loginButton.click();
            Thread.sleep(1000);
            WebElement logOutButton = driver.findElement(By.xpath("//div[@class='header-links']//li//a[@class='ico-logout']"));
            logOutButton.click();
        }


    }

    @Test(priority = 3)
    public void verifyHardAssert() {
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("parvathyk285@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("Parvathy#1998");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement logOutButton = driver.findElement(By.xpath("//div[@class='header-links']//li//a[@class='ico-logout']"));
        WebElement value= driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actValue=value.getText();
        String expValue="parvathyk285@gmail.com";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actValue,expValue,"Error::Values Mismatch");
        logOutButton.click();
        System.out.println("This is after method");
        softAssert.assertAll();
    }
}

