package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.*;

public class SearchAddItemTest extends BaseTest {
    private static final String ITEM_NAME = "laptop";
    private static final String ADDED_MESSAGE = "Added to Cart";

    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private ItemPage itemPage;
    private AddToCartConfirmationPage addToCartConfirmationPage;
    private SignInPage signInPage;

    private final SoftAssert softAssert = new SoftAssert();

    @Given("User is on Main Page")
    public void userIsOnMainPage() {
        mainPage = new MainPage(driver, softAssert);
    }

    @When("User enters item search value")
    public void userEntersValue() {
        Assert.assertTrue(mainPage.isSearchFiledAvailable());
        mainPage.setSearchValue(ITEM_NAME);
    }

    @And("User is navigated to SearchResults Page")
    public void userNavigatesToSearchResults() {
        Assert.assertTrue(mainPage.isSearchButtonAvailable());
        searchResultPage = mainPage.clickSearchButton();
    }

    @And("User clicks on item and gets navigated to the Item Page")
    public void userNavigatesToItemPage() {
        Assert.assertTrue(searchResultPage.isFirstSearchResultAvailable());
        Assert.assertTrue(searchResultPage.getFirstSearchResultValue().contains(ITEM_NAME));

        itemPage = searchResultPage.clickFirstSearchResult();
    }

    @And("User adds item to the cart")
    public void userAddsItemToCart() {
        Assert.assertTrue(itemPage.isAddToCartAvailable());
        addToCartConfirmationPage = itemPage.clickAddtoCartButton();
    }

    @And("User is navigated to Confirmation Page")
    public void userNavigatesToConfirmation() {
        Assert.assertEquals(addToCartConfirmationPage.getAddedToCartMessage(), ADDED_MESSAGE);
    }

    @And("User proceeds to check out")
    public void userProceedsToCheckOut() {
        Assert.assertTrue(addToCartConfirmationPage.isToCheckOutAvailable());
        signInPage = addToCartConfirmationPage.clickToCheckOut();
    }

    @Then("User is successfully navigated to SignIn Page")
    public void userNavigatesToSignIn() {
        Assert.assertTrue(signInPage.isContinueButtonAvailable());
        softAssert.assertAll();
    }
}