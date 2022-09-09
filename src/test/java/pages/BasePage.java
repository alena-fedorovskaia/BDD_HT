package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.asserts.SoftAssert;

public class BasePage {
    private static final int TIMEOUT = 10;

    protected WebDriver driver;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, TIMEOUT);
        PageFactory.initElements(finder, this);
    }
}
