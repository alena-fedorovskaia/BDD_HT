package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;


public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//*[@data-index = '4']")
    WebElement firstSearchResult;

    public SearchResultPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public boolean isFirstSearchResultAvailable() {
        return firstSearchResult.isDisplayed() && firstSearchResult.isEnabled();
    }

    public String getFirstSearchResultValue() {
        return firstSearchResult.getText().toLowerCase();
    }

    public ItemPage clickFirstSearchResult() {
        firstSearchResult.click();
        return new ItemPage(driver, softAssert);
    }
}
