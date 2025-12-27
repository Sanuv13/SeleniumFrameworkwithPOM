package org.example.Pages;

import Baseclass.CommonToAllPages;
import org.apache.poi.ss.formula.functions.T;
import org.example.Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends CommonToAllPages {

    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

//private By resister_button =By.xpath("//a[contains(@href,'route=account/register')]/parent::div/h2");
    //a[contains(@href,'route=account/register') and text()="Continue"]
    private By resister_button =By.xpath("//a[contains(@href,'route=account/register') and text()=\"Continue\"]");
    private By first_name=By.name("firstname");
    private By last_name=By.name("lastname");
    private By email=By.name("email");
    private By telephone=By.name("telephone");
    private By password=By.name("password");
    private By confirm_pass =By.id("input-confirm");
    private By newslellet_yes=By.xpath("//input[@name=\"newsletter\" and @value=\"1\"]");
    private By newslellet_no=By.xpath("//input[@name=\"newsletter\" and @value=\"0\"]");
    private By check=By.xpath("//input[@name=\"agree\" and @value=\"1\"]");
    private By submit_btn=By.xpath("//input[@value=\"Continue\"]");
    private By confirm_msg=By.xpath("//div[@id=\"content\"]/h1[text()=\"Your Account Has Been Created!\"]");
   // private By confirm_msg=By.xpath("//h1[text()=\"Your Account Has Been Created!\"]");

public String registrationWithValidData(String fname, String lname ,String Email,String Tele,String pass,String conpass,String letter){
    openURL();
    WaitHelper.waitForElementClickable(resister_button);
    clickElement(resister_button);
    enterInput(first_name ,fname);
    enterInput(last_name,lname);
    enterInput(email,Email);
    enterInput(telephone,Tele);
    enterInput(password,pass);
    enterInput(confirm_pass,conpass);
    if (letter.equalsIgnoreCase("Yes")) {
        clickElement(newslellet_yes);
    } else {
        clickElement(newslellet_no);
    }
    WebElement checkbox=driver.findElement(check);
    checkbox.click();
    WaitHelper.waitForElementClickable(submit_btn);
    clickElement(submit_btn);

    WaitHelper.waitforTextLocated(confirm_msg);
    WaitHelper.waitForElementVisible(confirm_msg);
    return getData(confirm_msg);


}
}
