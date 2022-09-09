package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com";
    public static WebDriver driver;
    static final String CHROME_DRIVER_PATH = "src\\test\\resources\\webdriver\\chromedriver.exe";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(AMAZON_HOME_PAGE_URL);
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
