import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_SignUpPage;
import Pages.P04_AccountCreatedPage;
import Utilities.Utilitiy;
import org.openqa.selenium.UnableToSetCookieException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_HomePage {
    private WebDriver driver ;
    @BeforeMethod
    public void setupdriver (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void Signup (){
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).name_signup("AbdallahSayed")
                .Email_signup("Abdalllla@coc.net").SignupButton();
        new P03_SignUpPage(driver).password("Abdallah@123")
                .firstname("Abdallah").lastname("Sayed")
                .address("AinShams").country_list("Canada").state("aaa")
                .city("Ca").zipcode("2421").mobile_number("01148200717").create_account_button();
        P04_AccountCreatedPage o = new P04_AccountCreatedPage(driver);
        Assert.assertEquals(o.accountCreated_messege(),"ACCOUNT CREATED!");
    }
    @AfterMethod
    public void quit (){
        //  driver.quit();
    }

}
