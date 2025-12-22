package org.example.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.Drivers.DriverManager.getDriver;

import java.time.Duration;

public class WaitHelper {


    public static WebElement waitForElementVisible(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForElementVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForElementClickable(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
       return  wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static WebElement waitForElementClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //public static WebElement waitforTextLocated(WebElement element2){
       // WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(10));
       // return wait.until(ExpectedConditions.visibilityOfElementLocated(element2));
   // }
    public static WebElement waitforTextLocated(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

}


