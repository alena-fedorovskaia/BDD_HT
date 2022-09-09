package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"nav-global-location-popover-link\"]")
    WebElement deliverTo;

    @FindBy(xpath = "//*[@id=\"GLUXCountryListDropdown\"]")
    WebElement countryDropDown;

    String countrySelectId = "GLUXCountryList";

    @FindBy(xpath = "//*[@id=\"a-popover-1\"]/div/div[2]/span")
    WebElement doneButton;

    @FindBy(xpath = "//*[@id=\"glow-ingress-line2\"]")
    WebElement deliveryCountry;

    @FindBy(xpath = "//*[@id=\"icp-nav-flyout\"]")
    WebElement LangCurSettings;

    public MainPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public boolean isSearchFiledAvailable() {
        return searchField.isDisplayed() && searchField.isEnabled();
    }

    public void setSearchValue(String searchValue) {
        searchField.clear();
        searchField.sendKeys(searchValue);
    }

    public boolean isSearchButtonAvailable() {
        return searchButton.isDisplayed() && searchButton.isEnabled();
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver, softAssert);
    }

    public void clickDeliverTo() {
        deliverTo = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(deliverTo));
        deliverTo.click();
    }

    public void setCountry(String country) {
        countryDropDown = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(countryDropDown));

        Select countryList = new Select(driver.findElement(By.id(countrySelectId)));
        countryList.selectByVisibleText(country);

        countryDropDown.click();
    }

    public boolean isDoneButtonAvailable() {
        return doneButton.isDisplayed() && doneButton.isEnabled();
    }

    public void clickDoneButton() {
        doneButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(doneButton));
        doneButton.click();
    }

    public String getDeliveryCountry() {
        deliveryCountry = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(deliveryCountry));
        return deliveryCountry.getText();
    }

    public String waitForDeliveryCountryChanged(String expectedName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(deliveryCountry, expectedName));
        return deliveryCountry.getText();
    }

    public boolean isLangCurSettingsAvailable() {
        return LangCurSettings.isDisplayed() && LangCurSettings.isEnabled();
    }

    public LanguageCurrencySettingsPage clickLangCurSettings() {
        LangCurSettings.click();
        return new LanguageCurrencySettingsPage(driver, softAssert);
    }
}



