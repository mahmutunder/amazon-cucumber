package com.amazon.step_definitions;


import com.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
         var screenshot= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

         scenario.attach(screenshot, "image/png",scenario.getName());

        }


        Driver.close();
    }
}
