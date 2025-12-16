package Base;

import org.example.Drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTests {


    @BeforeMethod

    public void setup(){
        DriverManager.init();
    }

   @AfterMethod
    public void tearDown(){
        DriverManager.down();
   }
}
