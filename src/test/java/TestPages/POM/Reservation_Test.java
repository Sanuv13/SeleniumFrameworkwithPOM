package TestPages.POM;

import Base.CommonToAllTests;
import Utils.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.checkerframework.checker.units.qual.C;
import org.example.Pages.RegistrationPage;
import org.example.Utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.Drivers.DriverManager.driver;

public class Reservation_Test extends CommonToAllTests {
    private static final Logger log= LoggerFactory.getLogger(Reservation_Test.class);

    @Owner("Sanu")
    @Description("Check the registration")

@Test(dataProvider = "registrationData")
public void registration(String name,String nameLast,String EmailId,String PhoneNo,String Pwd,String ConfirmPWD,  String news){

    RegistrationPage regpage=new RegistrationPage(driver);
String confirmation=regpage.registrationWithValidData(name,nameLast,EmailId,PhoneNo,Pwd,ConfirmPWD,news);
log.info("verify success msg is displaying after successfull registration");
    assertThat(confirmation).isNotNull().isNotBlank().isNotEmpty();
    Assert.assertEquals(confirmation, PropertiesReader.readKey("Success_Msg"));



}















@DataProvider
public Object[][] registrationData() {
    return UtilExcel.getDataFromSheet("Sheet1");
}
}
