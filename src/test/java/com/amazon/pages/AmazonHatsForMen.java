package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Watchable;

public class AmazonHatsForMen {

    public AmazonHatsForMen(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="quantity")
    public WebElement quantitySelect;

    @FindBy(id="add-to-cart-button")
    public WebElement addToCartBtn;
}
