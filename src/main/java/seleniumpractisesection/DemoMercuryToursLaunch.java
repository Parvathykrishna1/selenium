package seleniumpractisesection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoMercuryToursLaunch {
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
        // testInitials("Chrome");
        testInitials("Edge");
        driver.get("http://demo.guru99.com/test/newtours/");
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String actualUrl = driver.getCurrentUrl();
        //System.out.println(actualUrl);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.close();
        //testInitials("Firefox");
    }
}

