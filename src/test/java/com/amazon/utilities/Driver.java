package com.amazon.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    private Driver() {
    }


    public static WebDriver getDriver() {

        String browserType = ConfigurationReader.getProperty("browser");

        if (driverPool.get() == null) {

            switch (browserType) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        }


        return driverPool.get();
    }



    public static void close(){

        if(driverPool.get() !=null){
            driverPool.get().quit();
            driverPool.remove();
        }

    }

}
