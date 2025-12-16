package org.example.Pages;

import Baseclass.CommonToAllPages;
import org.example.Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends CommonToAllPages {
    //webdriver
    //class
    //locator
    //page action

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By email_id=By.id("input-email");
    private By password=By.id("input-password");
    private By loginbutton=By.xpath("//input[@class=\"btn btn-primary\"]");
    private By error_msg=By.xpath("//div[contains(@class,\"alert-danger\")][contains(normalize-space(),\"Warning: No match for E-Mail Address and/or Password.\")]");
private By Account_page=By.xpath("//h2[text()='My Account']");
private By listofitems=By.xpath("//div[@class=\"list-group\"]/a");
private By dropdownitems=By.xpath("//ul[@class=\"nav navbar-nav\"]/li");
    public String loginWithInvalidCredentials(String Username,String Pass) {
        openURL();
        enterInput(email_id, Username);
        enterInput(password, Pass);
        clickElement(loginbutton);

        WaitHelper.waitForElementVisible(error_msg);
        return getData(error_msg);
    }

    public String loginWithValidCredentials(String username ,String pass){
        openURL();
        enterInput(email_id,username);
        enterInput(password,pass);
        clickElement(loginbutton);
        WaitHelper.waitforTextLocated(Account_page);
        return getData(Account_page);

    }
    public List<String> getManuOption(){
        openURL();
        List<WebElement> elements=driver.findElements(listofitems);
        List<String> optionTexts = new ArrayList<>();
        for(WebElement WE:elements){
            optionTexts.add(WE.getText());
        }
        return optionTexts;

    }

    public List<String> dropDownOptions(){
        openURL();
        List<WebElement >element=driver.findElements(dropdownitems);
        List<String> data=new ArrayList<>();
        for(WebElement Web:element){
            data.add(Web.getText());

        }
        return data;

    }



}
