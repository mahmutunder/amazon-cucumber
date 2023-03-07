package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHatsResultPage {

    public AmazonHatsResultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")
    public WebElement firstHatLink;
}
