package seleniumpractisesection;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoMercuryToursCommands {
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
    public void verifySignOn() {
        driver.get("http://demo.guru99.com/test/newtours/");
        WebElement signOnMenu = driver.findElement(By.xpath("//a[@href='login.php']"));
        signOnMenu.click();
        WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("parvathy");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Parvathy@123");
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        String value = submitButton.getAttribute("value");
        System.out.println(value);
    }
}