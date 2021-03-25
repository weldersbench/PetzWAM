package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.Base;
import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.List;
import pages.Product;

import static org.junit.Assert.assertEquals;

public class SearchProduct extends Base {
    private Base base;
    private Home home;
    private List list;
    private Product productClass;

    public SearchProduct(WebDriver driver, Base base) {
        super(driver);
        this.base = base;
    }

    @Given("^I access Petz homepage$")
    public void iAccessPetzHomepage() {
        base.driver.get("https://www.petz.com.br");
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product){
        home.searchWithEnter(product);

    }

    @Then("^I see a list of product \"([^\"]*)\"$")
    public void iSeeAListOfProduct(String product){
        assertEquals(product + " - Produtos pet em promoção | Petz",list.readTitleTab());

        assertEquals("Resultado para \"" + product + "\"", list.readResultBy());

    }

    @And("^I click in product \"([^\"]*)\"$")
    public void iClickInProduct(String product){
        list.clickAtDesiredProduct(product);

    }

    @Then("^show the title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void showTheTitleAndPrice(String product, String price){

        assertEquals(product + " - Produtos pet em promoção | Petz", productClass.readTitleTab());

        assertEquals(product, productClass.readProductTitle());

        assertEquals(price, productClass.readPriceCurrent());

    }
}
