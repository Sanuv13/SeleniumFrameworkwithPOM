package org.example.Drivers;

import org.openqa.selenium.WebDriver;
import org.example.Utilities.PropertiesReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;

public class DriverManager
{
    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver driver){
        DriverManager.driver=driver;
    }

    //want to start a browser
    public static  void init(){
        String browser=PropertiesReader.readKey("browser");
        browser=browser.toLowerCase();

        switch (browser){

            case "chrome":

                ChromeOptions chromeoptions=new ChromeOptions();
                chromeoptions.addArguments("--start-maximize");
                chromeoptions.addArguments("--headless=new");
                driver=new ChromeDriver(chromeoptions);
                break;

            case "edge":
                EdgeOptions edgeoptions=new EdgeOptions();
                edgeoptions.addArguments("--start-maximize");
                edgeoptions.addArguments("--headless=new");
                driver=new EdgeDriver(edgeoptions);
                break;
            default:
                System.out.println("Not browser Supported!!!");

        }

    }
    public static void down(){
        if(getDriver()!=null){
           driver.quit();
           driver=null;
        }
    }




}

