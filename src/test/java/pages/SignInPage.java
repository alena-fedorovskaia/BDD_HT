package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    public SignInPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public boolean isContinueButtonAvailable() {
        return continueButton.isDisplayed() && continueButton.isEnabled();
    }
}
