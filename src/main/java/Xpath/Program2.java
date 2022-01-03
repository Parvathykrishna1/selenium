package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Program2 {
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

    public static void main(String args[]) {
        testInitials("Chrome");
        driver.get("https://login.yahoo.com/account/create");
        driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Your-Name"); // Will send values to First Name tab
        driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Your-Last_name"); //xpath for last name box
        driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("email@yahoo.com"); //xpath for email box
        driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("123456789"); //xpath for phone number box
        driver.findElement(By.xpath("//select[@id='usernamereg-month']")).click(); //xpath for usermonth box
        driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("01"); //xpath for userday box
        driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1999");// xpath for user year
        driver.findElement(By.xpath("//button[@id='reg-submit-button']")).click();// xpath for submit button
    }
}
