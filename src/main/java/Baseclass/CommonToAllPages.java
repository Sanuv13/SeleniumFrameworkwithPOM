package Baseclass;
import org.example.Utilities.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import  org.example.Utilities.WaitHelper;

import static org.example.Drivers.DriverManager.getDriver;
import static org.example.Utilities.WaitHelper.waitForElementClickable;
import static org.example.Utilities.WaitHelper.waitForElementVisible;

public class CommonToAllPages {

    public void openURL(){
        getDriver().get(PropertiesReader.readKey("url"));

    }
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }
    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }
    public String getData(By by){
        return getDriver().findElement(by).getText();

    }
    public String getData(WebElement by){
        return by.getText();
    }
    //Email field or password field
    //Sometimes the field already contains old value (browser autofill).
    public void clearAndEnter(By by,String text){
        WebElement element= waitForElementVisible(by);
        element.clear();
        element.sendKeys(text);
    }
    public void waitAndClick(By by){
      waitForElementClickable(by).click();


        }

    }



