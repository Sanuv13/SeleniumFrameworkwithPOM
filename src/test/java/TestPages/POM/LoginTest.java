package TestPages.POM;

import Base.CommonToAllTests;
import io.qameta.allure.*;
import org.example.Drivers.DriverManager;
import org.example.Pages.LoginPage;
import org.example.Utilities.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends CommonToAllTests {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Owner("Sanu")
    @Description("Login the openCart with invalid credentials")
   @Test
    public void Negative_Test_Invalid_Login() {
        log.info("Verify error message is showing if user anme and password is wrong");
        LoginPage loginpage = new LoginPage(DriverManager.getDriver());
        String Error = loginpage.loginWithInvalidCredentials(PropertiesReader.readKey("InvalidE-Mail"), PropertiesReader.readKey("InvalidPasswor"));
        log.info("checking the error message");
        assertThat(Error).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(Error, PropertiesReader.readKey("ErrorMsg"));

    }


    @Owner("Sanu")
    @Description("Login the Opencart application with valid credentials")
@Test


    public void Positive_Valid_Login(){
        log.info("Verify next page loaded successfully when user entered the correct data");

        LoginPage loginPage =new LoginPage(DriverManager.getDriver());
        String next_page= loginPage.loginWithValidCredentials(PropertiesReader.readKey("E-Mail"),PropertiesReader.readKey("Password"));
        log.info("Verify next page is loaded");

        Assert.assertEquals(next_page,PropertiesReader.readKey("Page_name"));


    }


    @Step("Menu items found: {items}")
    public void logMenuItems(List<String> items) {
        // nothing needed here
    }

    @Attachment(value = "Menu Items", type = "text/plain")
    public String attachMenuItems(List<String> items) {
        return String.join("\n", items);
    }
    @Owner("Sanu")
    @Description("Check the list of options")
@Test
    public void getoptiondata(){
        LoginPage loginPage =new LoginPage(DriverManager.getDriver());
        List<String> items=loginPage.getManuOption();
        logMenuItems(items);
        attachMenuItems(items);
        Assert.assertTrue(items.contains("My Account"));
    }

    @Owner("Sanu")
    @Description("Retrive the Dropdown list")

@Test
    public void getDropDownData(){
        LoginPage loginpage=new LoginPage(DriverManager.getDriver());
        List<String> dataiteams=loginpage.dropDownOptions();
        attachMenuItems(dataiteams);
        Assert.assertTrue(dataiteams.contains("Desktops"));
    }
}




