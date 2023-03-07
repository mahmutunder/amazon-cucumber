package com.amazon.step_definitions;

import com.amazon.pages.AmazonGoCart;
import com.amazon.pages.AmazonHatsForMen;
import com.amazon.pages.AmazonHatsResultPage;
import com.amazon.pages.AmazonHomePage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Amazon_hats_for_men {

    AmazonHomePage homePage = new AmazonHomePage();
    AmazonHatsResultPage resultPage = new AmazonHatsResultPage();
    AmazonHatsForMen hatsForMen = new AmazonHatsForMen();

    AmazonGoCart amazonGoCart = new AmazonGoCart();

    Select select = null;

    double price = 0;
    double priceTotal = 0;

    String unitPrice = "";
    String totalPrice = "";

    @Given("user is on the amazon home page")
    public void user_is_on_the_amazon_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user search for {string}")
    public void user_search_for(String key) {

        homePage.searchBox.sendKeys(key);
    }

    @When("user click the search button")
    public void user_click_the_search_button() {

        homePage.searchButton.click();
    }

    @When("users clicks first hat link")
    public void users_clicks_first_hat_link() {
        resultPage.firstHatLink.click();
    }

    @When("user make the first appearing hat quantity {int}")
    public void user_make_the_first_appearing_hat_quantity(Integer value) {

        select = new Select(hatsForMen.quantitySelect);

        select.selectByValue(value + "");


    }

    @When("user add hats to cart")
    public void user_add_hats_to_cart() {

        hatsForMen.addToCartBtn.click();

    }

    @When("user open cart and assert that the total price and quantity are correct")
    public void user_open_cart_and_assert_that_the_total_price_and_quantity_are_correct() {

        amazonGoCart.goToCart.click();


        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("2"));

        unitPrice = amazonGoCart.oneUnitPrice.getText();
        unitPrice = unitPrice.substring(1);
        price = Double.parseDouble(unitPrice);

        totalPrice = amazonGoCart.totalPrice.getText();
        totalPrice = totalPrice.substring(1);
        priceTotal = Double.parseDouble(totalPrice);

        Assert.assertTrue("Total price verification fail", priceTotal == (2 * price));


    }

    @When("user reduce the quantity from two to one in Cart for the item selected")
    public void user_reduce_the_quantity_from_to_in_cart_for_the_item_selected() {

        select.selectByValue("1");
       // System.out.println(select.getFirstSelectedOption().getText());


    }

    @Then("Verify that the total price and quantity has been correctly changed")
    public void verify_that_the_total_price_and_quantity_has_been_correctly_changed() throws InterruptedException {

     //   Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        Assert.assertTrue(select.getFirstSelectedOption().getText().trim().equals("1"));



        // we can do a method but we want to show you how hard we are working
        unitPrice = amazonGoCart.oneUnitPrice.getText();
        unitPrice = unitPrice.substring(1);
        price = Double.parseDouble(unitPrice);

        totalPrice = amazonGoCart.totalPrice.getText();
        totalPrice = totalPrice.substring(1);
        priceTotal = Double.parseDouble(totalPrice);

        Assert.assertTrue(price == priceTotal);
    }

}
