package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;


public class ItemPage extends BasePage {
    @FindBy(xpath = "//*[@id='add-to-cart-button']")
    WebElement addToCartButton;

    public ItemPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public boolean isAddToCartAvailable() {
        return addToCartButton.isDisplayed() && addToCartButton.isEnabled();
    }

    public AddToCartConfirmationPage clickAddtoCartButton() {
        addToCartButton.click();
        return new AddToCartConfirmationPage(driver, softAssert);
    }

}
