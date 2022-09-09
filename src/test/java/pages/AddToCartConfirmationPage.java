package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartConfirmationPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
    WebElement toCheckOutButton;

    @FindBy(xpath = "//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4")
    WebElement addedToCartMessage;

    public AddToCartConfirmationPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public String getAddedToCartMessage() {
        addedToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(addedToCartMessage));

        return addedToCartMessage.getText();
    }

    public boolean isToCheckOutAvailable() {
        return toCheckOutButton.isDisplayed() && toCheckOutButton.isEnabled();
    }

    public SignInPage clickToCheckOut() {
        toCheckOutButton.click();
        return new SignInPage(driver, softAssert);
    }
}
