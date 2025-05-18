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

public class TC02_Sign_UP {
    public Logger LOGGER = LogManager.getLogger();
    private WebDriver driver ;
    @BeforeMethod
    public void setupdriver () throws IOException {
        SetupDriver(DataUtils.getPropertyValue("environment","BROWSER"));
        driver = DriverFactoryClass.getdriver();
        getdriver().get(DataUtils.getPropertyValue("environment","BASE_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void Signup (){
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).name_signup("AbdallahSayed")
                .Email_signup(DataUtils.getJsonData("Data" , "SignUPMail")).SignupButton();
        new P03_SignUpPage(driver).password("Abdallah@123")
                .firstname("Abdallah").lastname("Sayed")
                .address("AinShams").country_list("Canada").state("aaa")
                .city("Ca").zipcode("2421").mobile_number("01148200717").create_account_button();
        P04_AccountCreatedPage o = new P04_AccountCreatedPage(driver);
        Assert.assertEquals(o.accountCreated_messege(),"ACCOUNT CREATED!");
        new P04_AccountCreatedPage(driver).continue_button();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
        Assert.assertEquals(Logged_visability.Logged_as_Button(),"Logged in as AbdallahSayed");
        new P01_HomePage(driver).Account_Delete_button();
        Assert.assertEquals(Logged_visability.Deleted_Account_messege(),"ACCOUNT DELETED!");
    }
    @Test
    public void Signup_To_Checkout (){
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).name_signup("AbdallahSayed")
                .Email_signup(DataUtils.getJsonData("Data" , "SignUPMail")).SignupButton();
        new P03_SignUpPage(driver).password("Abdallah@123")
                .firstname("Abdallah").lastname("Sayed")
                .address("AinShams").country_list("Canada").state("aaa")
                .city("Ca").zipcode("2421").mobile_number("01148200717").create_account_button();
//        P03_SignUpPage K = new P03_SignUpPage(driver);
//        String ActualAddress = K.get_address();
        P04_AccountCreatedPage o = new P04_AccountCreatedPage(driver);
        Assert.assertEquals(o.accountCreated_messege(),"ACCOUNT CREATED!");
        new P04_AccountCreatedPage(driver).continue_button();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
        Assert.assertEquals(Logged_visability.Logged_as_Button(),"Logged in as AbdallahSayed");
        new P01_HomePage(driver).Products_Button();
        new P05_ProductsPage(driver).AddToCart_1_Button().Continue_Shopping_button()
                .AddToCart_2_Button().View_Cart_Button().ProccedToCheckout_Button();

        P08_CheckOutPage DeliveryAddress = new P08_CheckOutPage(driver);
        Assert.assertEquals(DeliveryAddress.Delivery_address(),"AinShams");
        Assert.assertEquals(DeliveryAddress.Billing_address(),"AinShams");
        new P01_HomePage(driver).Account_Delete_button();
        Assert.assertEquals(Logged_visability.Deleted_Account_messege(),"ACCOUNT DELETED!E-commerce solutions");
        new P01_HomePage(driver).Continue_Button_AfterDeleteAccount();

    }

    @Test
    public void CheckoutWithoutSignUp () {
        new P05_ProductsPage(driver).AddToCart_1_Button().Continue_Shopping_button()
                .AddToCart_2_Button().View_Cart_Button().ProccedToCheckout_Button();
        new  P07_ViewCartPage(driver).RegisterOrLogin_Button();
        new P02_LoginPage(driver).name_signup("AbdallahSayed")
                .Email_signup(DataUtils.getJsonData("Data" , "SignUPMail")).SignupButton();
        new P03_SignUpPage(driver).password("Abdallah@123")
                .firstname("Abdallah").lastname("Sayed")
                .address("AinShams").country_list("Canada").state("aaa")
                .city("Ca").zipcode("2421").mobile_number("01148200717").create_account_button();
        P04_AccountCreatedPage s = new P04_AccountCreatedPage(driver);
        Assert.assertEquals(s.accountCreated_messege(),"ACCOUNT CREATED!");
        new P04_AccountCreatedPage(driver).continue_button();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
        Assert.assertEquals(Logged_visability.Logged_as_Button(),"Logged in as AbdallahSayed");
        new P01_HomePage(driver).Cart_Button();
        new P07_ViewCartPage(driver).ProccedToCheckout_Button();
        new P08_CheckOutPage(driver).Comment().PlaceOrder_Button();
        new P09_PaymentPage(driver).Name_on_Card().Card_Number()
                .CVC().Expiration_M().Expiration_Y().ConfirmOrder_button();
        P09_PaymentPage Payment_Confirmation = new P09_PaymentPage(driver);
        Assert.assertEquals(Payment_Confirmation.Success_Payment_Messege(),"Congratulations! Your order has been confirmed!");
        new P09_PaymentPage(driver).DownloadInvoice_Button().Continue_AfterPaying();
        new P01_HomePage(driver).Account_Delete_button();
        Assert.assertEquals(Logged_visability.Deleted_Account_messege(),"ACCOUNT DELETED!E-commerce solutions");
        new P01_HomePage(driver).Continue_Button_AfterDeleteAccount();
    }
    @AfterMethod
    public void quit (){
          driver.quit();
    }

}
