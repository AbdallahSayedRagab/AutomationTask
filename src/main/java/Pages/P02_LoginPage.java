package Pages;

import Utilities.DataUtils;
import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    public P02_LoginPage(WebDriver driver){
        this.driver = driver ;
    }

    private WebDriver driver;
   // private final By Signup_login_button = By.xpath("//a[@href='/login']");
    private final By name_signup = By.xpath("//input[@placeholder='Name']");
    private final By Email_signup = By.xpath("//input[@data-qa='signup-email']");
    private final By SignupButton = By.xpath("//button[@data-qa='signup-button']");
    private final By Login_Email = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By Login_Password = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By Login_button = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By Login_To_your_account_messege = By.xpath("//h2[contains(text(), 'Login to your account')]");
    private final By Incorrect_Email_Messege = By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]");


    public String Incorrect_Email_Messege () {

        return Utilitiy.GETTEXT(driver,Incorrect_Email_Messege);
    }

    public String Login_To_your_account_messege () {

        return Utilitiy.GETTEXT(driver,Login_To_your_account_messege);
    }

    public P02_LoginPage Login (){
        String EMAIL =DataUtils.getJsonData("Data","ValidLoginEmail");
        String password =DataUtils.getJsonData("Data","Password");
        Utilitiy.SENDKEYS(driver,Login_Email,EMAIL);
        Utilitiy.SENDKEYS(driver,Login_Password,password);
        Utilitiy.CLICKONELEMENTS(driver,Login_button);
        return this;
    }
//    public P02_LoginPage Login_Email (String EMAIL){
//        Utilitiy.SENDKEYS(driver,Login_Email,EMAIL);
//        return this;
//    }
//    public P02_LoginPage Login_Password (String password){
//        Utilitiy.SENDKEYS(driver,Login_Password,password);
//        return this;
//    }
//    public P02_LoginPage Login_button (){
//        Utilitiy.CLICKONELEMENTS(driver,Login_button);
//        return this;
//    }

    public P03_SignUpPage Signup_Register (){
        String NameSignup =DataUtils.getJsonData("Data" , "Name_Signup");
        String EMAIL =   DataUtils.getJsonData("Data","SignUPMail");
        Utilitiy.SENDKEYS(driver,name_signup,NameSignup);
        Utilitiy.SENDKEYS(driver,Email_signup,EMAIL);
        Utilitiy.CLICKONELEMENTS(driver,SignupButton);
        return new P03_SignUpPage(driver);
    }
//    public P02_LoginPage name_signup (String NameSignup){
//        Utilitiy.SENDKEYS(driver,name_signup,NameSignup);
//        return this;
//    }
//
//    public P02_LoginPage Email_signup (String EMAIL){
//        Utilitiy.SENDKEYS(driver,Email_signup,EMAIL);
//        return this;
//    }
//    public P02_LoginPage SignupButton (){
//        Utilitiy.CLICKONELEMENTS(driver,SignupButton);
//        return this;
//    }


//    public P02_HomePage clickLoginbutton (){
//        Utilitiy.CLICKONELEMENTS(driver,LoginButton);
//        return new P02_HomePage(driver);
//
//    }

}
