package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

public class UpdateDeliveryCountryTest extends BaseTest {
    private static final String DELIVERY_COUNTRY = "Israel";

    private MainPage mainPage;

    private final SoftAssert softAssert = new SoftAssert();

    @Given("User is on main Page")
    public void userIsOnMainPage() {
        mainPage = new MainPage(driver, softAssert);
    }

    @When("User clicks DeliveryTo Field")
    public void userClicksDeliveryTo() {
        mainPage.clickDeliverTo();
    }

    @And("User selects country from drop down list and confirms it")
    public void userSelectsCountry() {
        mainPage.setCountry(DELIVERY_COUNTRY);
        Assert.assertTrue(mainPage.isDoneButtonAvailable(), "Done Button is not available");
        mainPage.clickDoneButton();
    }

    @Then("Selected delivery country is displayed on Main Page")
    public void deliveryCountrySuccessfullyChanged() {
        mainPage.waitForDeliveryCountryChanged(DELIVERY_COUNTRY);
        Assert.assertEquals(mainPage.getDeliveryCountry(), DELIVERY_COUNTRY, "Updated delivery country is not displayed");
        softAssert.assertAll();
    }
}
