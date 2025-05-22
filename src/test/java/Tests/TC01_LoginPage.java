package Tests;

import DriverFactory.DriverFactoryClass;
import Lisenters.IInvociedMethodListener;
import Lisenters.ITestResultListener;
import Pages.*;
import Utilities.DataUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactoryClass.SetupDriver;
import static DriverFactory.DriverFactoryClass.getdriver;

@Listeners({IInvociedMethodListener.class , ITestResultListener.class})
public class TC01_LoginPage {
    public Logger LOGGER = LogManager.getLogger();
    private WebDriver driver ;
   @BeforeMethod
   public void setupdriver () throws IOException {
       SetupDriver(DataUtils.getPropertyValue("environment","BROWSER"));
       driver = DriverFactoryClass.getdriver();
       getdriver().get(DataUtils.getPropertyValue("environment","BASE_URL"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

   }


//    @Test
//    public void ValidLogin (){
//        new P01_HomePage(driver).Signup_login_button();
//          new P02_LoginPage(driver).name_signup("AbdallahSayed")
//                .Email_signup("Abdallah@coc.net").SignupButton();
//
//    }

    @Test
    public void ValidLogin () {
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).
                Login();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
        Assert.assertEquals(Logged_visability.Logged_as_Button(), "Logged in as AbdallahSayed");
//        new P01_HomePage(driver).Account_Delete_button();
//        Assert.assertEquals(Logged_visability.Deleted_Account_messege(), "ACCOUNT DELETED!");
    }
    @Test
    public void InvalidLogin(){
       LOGGER.info("Start");
        new P01_HomePage(driver).Signup_login_button();
        P02_LoginPage visiable_messeges = new P02_LoginPage(driver);
        Assert.assertEquals(visiable_messeges.Login_To_your_account_messege(),"Login to your account");
        new P02_LoginPage(driver).
                Login();
        Assert.assertEquals(visiable_messeges.Incorrect_Email_Messege(),"Your email or password is incorrect!");
        LOGGER.info("End");
        }
    @Test
    public void Logout(){
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).
                Login();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
     //   Assert.assertEquals(Logged_visability.Logged_as_Button(), "Logged in as AbdallahSayed");
        new P01_HomePage(driver).Logout_Button();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }


    @AfterMethod
    public void quit () {
        driver.quit();
    }
    }




