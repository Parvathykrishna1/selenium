package com.obsqura.seleniumcommands;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
        // driver.manage().deleteAllCookies();
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
        email.sendKeys("parvathyk2@gmail.com");
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
        email.sendKeys("parvathyk2@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
        password.sendKeys("Parvathy#1998");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        confirmPassword.sendKeys("Parvathy#1998");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        WebElement successfulMessage = driver.findElement(By.xpath("//div[@class='result']"));
        String S = successfulMessage.getText();
        String actlMessage = successfulMessage.getText();
        String expMessage = "Registration successful";
        System.out.println(S);
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
    public void verifyDropDown() {
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement registerMenu = driver.findElement(By.xpath("//a[@href='register.php']"));
        registerMenu.click();
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        // select.selectByVisibleText("INDIA");
        // select.selectByValue("BANGLADESH");
        //  select.selectByIndex(3);
        List<String> expDropDownValues = new ArrayList<>();
        expDropDownValues.add("ALBANIA");
        expDropDownValues.add("ALGERIA");
        expDropDownValues.add("AMERICAN SAMOA");
        List<WebElement> dropDownObjects = select.getOptions(); //getOptions() is used to get actual list of items in the dropdown list
        List<String> actDropDownValues = new ArrayList<>();
        for (int i = 0; i < dropDownObjects.size(); i++) {
            actDropDownValues.add(dropDownObjects.get(i).getText());
        }
        System.out.println(actDropDownValues.size());
        System.out.println(actDropDownValues);
        // Assert.assertEquals(actDropDownValues,expDropDownValues,"Error:Invalid"); direct assertion not possible here bcz size varies.
    }


    @Test(priority = 6)
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\ravat\\Downloads");
        WebElement chkBoxAcceptFile = driver.findElement(By.xpath("//input[@id='terms']"));
        chkBoxAcceptFile.click();
        WebElement btnSubmitFile = driver.findElement(By.id("submitbutton"));
        btnSubmitFile.click();
    }


    @Test(priority = 7)
    public void verifySimpleAlert() {
        driver.get("https://demoqa.com/alerts");
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
        // alert.dismiss();
        // WebElement confirmText = driver.findElement(By.id("confirmResult"));
        // String cText = confirmText.getText();
        // System.out.println(cText);
    }

    @Test(priority = 9)
    public void verifyPromptAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement btnPromptAlert = driver.findElement(By.id("promtButton"));
        btnPromptAlert.click();
        Alert alert = driver.switchTo().alert();
        String actAlrtTxt = alert.getText();
        System.out.println(actAlrtTxt);
        alert.sendKeys("raj");
        alert.accept();
        WebElement msgDisplay = driver.findElement(By.id("promptResult"));
        String msg = msgDisplay.getText();
    }


    @Test(priority = 10)
    public void verifyMouseRightClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickMe = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).build().perform();
    }


    @Test(priority = 11)
    public void verifyDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick1 = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']//following-sibling::button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick1).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test(priority = 12)
    public void verifyDragDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//following-sibling::div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).build().perform();
    }


    @Test(priority = 13)
    public void verifyDragAndDropBy() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragMe = driver.findElement(By.id("dragBox"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragMe, 100, 100).build().perform();
    }


    @Test(priority = 13)
    public void verifyMouseOverActions() {
        driver.get("https://demoqa.com/menu/");
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        // selectMainItem("Main Item 2");
    }

    public void selectMainItem(String text) {
        List<WebElement> mainItems = driver.findElements(By.xpath("//ul[@id='nav']//a"));
        for (int i = 0; i < mainItems.size(); i++) {
            if (mainItems.get(i).getText().equals(text)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(mainItems.get(i)).build().perform();
            }
        }
    }

    @Test(priority = 14)
    public void verifyResizeByClickAndHold() throws InterruptedException {
        driver.get("https://demoqa.com/resizable");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        WebElement resizeMin = driver.findElement(By.xpath("//div[@id='resizable']"));
        WebElement resizeMax = driver.findElement(By.xpath("//div[@class='resizable-nolimit mt-4']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(resizeMin).clickAndHold().moveToElement(resizeMax).release().build().perform();
    }

    @Test(priority = 15)
    public void verifyWindowHandle() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        WebElement clickHere = driver.findElement(By.xpath("//p[@style='text-align:center']//a"));
        clickHere.click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement emailId = driver.findElement(By.xpath("//input[@type='text' and @name='emailid']"));
                emailId.sendKeys("helloo123@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
                submitButton.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
    }


    @Test(priority = 16)
    public void verifyFramesUsingSelenium() {
        driver.get("https://demoqa.com/frames");
        //driver.switchTo().frame("frame1");
        //driver.switchTo().frame(2);
        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);
        WebElement frameText = driver.findElement(By.id("sampleHeading"));
        System.out.println(frameText.getText());
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
    }

    @Test(priority = 17)
    public void verifyPageLoadWait() {
        driver.get("https://demo.guru99.com/popup.php");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);  //page load wait
    }

    @Test(priority = 18)
    public void implicitWaitingSelenium() {
        driver.get("http://demowebshop.tricentis.com/");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //selenium 4 supports this
        //WebDriverWait wait = new WebDriverWait(driver,20); before selenium 4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //after selenium 4
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-register")));
        WebElement registerMenu = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerMenu.click();
    }

    @Test(priority = 19)
    public void robotClass() throws AWTException {
        driver.get("http://demowebshop.tricentis.com/login");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("parvathyk2@gmail.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test(priority = 20)
    public void verifyFileUploadRobot() throws AWTException, InterruptedException {
        driver.get("https://www.naukri.com/registration/createAccount");
        Thread.sleep(2000);
        WebElement uploadResume = driver.findElement(By.xpath("//button[@class='uploadResume resman-btn-primary resman-btn-small']"));
        uploadResume.click();
        StringSelection select = new StringSelection("E:\\Resume.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
        Robot robot = new Robot();
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test(priority = 21)
    public void verifyTable() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<String> actData = new ArrayList<>();
        List<String> expData = new ArrayList<>(Arrays.asList("Island Trading","Helen Bennett","UK"));
        List<WebElement> rowElement = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        System.out.println(rowElement.size());
        for(int i=2;i< rowElement.size();i++){

        }
    }
}

