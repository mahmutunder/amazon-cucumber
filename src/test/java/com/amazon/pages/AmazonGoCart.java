package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonGoCart {

    public AmazonGoCart(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=sw_gtc']")
    public WebElement goToCart;


    @FindBy(xpath = "//div[@class='sc-item-price-block']//span")
    public WebElement oneUnitPrice;


    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
    public WebElement totalPrice;
}
