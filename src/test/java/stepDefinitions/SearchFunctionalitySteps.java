package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.HomePage;
import pageobject.JPMorganPage;
import pageobject.SearchResultPage;
import util.LoadProperties;

import java.util.Properties;

public class SearchFunctionalitySteps {

    public static LoadProperties loadPropFiles = new LoadProperties();
    Properties properties;
    private Logger logger = LoggerFactory.getLogger(SearchFunctionalitySteps.class);


    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    JPMorganPage jpMorganPage = new JPMorganPage();


    @Given("user launches the website successfully")
    public void launchSelenium() throws Exception {
        properties = loadPropFiles.getPropertyFileValue("testData.properties");
        homePage.launchUrl();
    }

    @Given("^User enters the '(.*)' in search box$")
    public void enterTextToSearch(String text) throws Exception {

        homePage.clickAcceptAll();
        homePage.enterGoogleSearchKeyWord(text);
        homePage.clickGoogleSearch();
    }

    @Given("^I am an user who launch the search engine$")
    public void launchSearchEngine() throws Exception {
        logger.info("Covered in the above step");
    }

    @Given("^I enter the '(.*)' in search box$")
    public void searchBox(String text) throws Exception {
        homePage.clickAcceptAll();
        homePage.enterGoogleSearchKeyWord(text);
        homePage.clickGoogleSearch();
    }

    @When("^I click the first search result$")
    public void firstSearchResult() throws Exception {
        searchResultPage.verifyPage();
        searchResultPage.clickRequiredUrl(properties.getProperty("validation.url.text.in.search.result"));
    }

    @When("I click on the search results")
    public void searchResult() throws Exception{
        searchResultPage.verifyPage();
        searchResultPage.clickRequiredUrl(properties.getProperty("url.text.in.search.result"));
    }

    @Then("^J.P.Morgon website should be launched$")
    public void launchJpMorgan() throws Exception {
        jpMorganPage.dismissConsentPageIfVisible();
    }

    @Then("^I should see the logo is displayed correctly$")
    public void logoIsDisplayed() throws Exception {
        jpMorganPage.verifyJpMorgonLogo();
    }

    @Then("I should not see the correct page loaded with logo")
    public void logoIsNotDisplayed() throws Exception{
        jpMorganPage.verifyJpMorgonLogoIsNotDisplayed();
    }

    @When("I should see results displayed")
    public void shouldSeeResults() throws Exception {
        searchResultPage.verifyPage();
        searchResultPage.verifyRequiredUrl(properties.getProperty("validation.url.text.in.search.result"));
    }

    @When("I click on the results which dont have J.P. Morgan")
    public void clickNonJPMorganLink() throws Exception{

        searchResultPage.verifyPage();
        searchResultPage.clickRequiredUrl(properties.getProperty("invalid.url.text.in.search.result"));
    }


}
