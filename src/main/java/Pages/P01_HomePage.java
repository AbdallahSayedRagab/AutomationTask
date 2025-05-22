package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    public P01_HomePage(WebDriver driver){
        this.driver = driver ;
    }
    private WebDriver driver;
    private final By Signup_login_button = By.xpath("//a[@href='/login']");
    private final By Logged_as_Button = By.xpath("//a[contains(text(),' Logged in as ')]");
    private final By Account_Delete_button = By.xpath("//a[contains(text(),' Delete Account')]");
    private final By Deleted_Account_messege = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private final By Continue_Button_AfterDeleteAccount = By.xpath("//a[@data-qa=\"continue-button\"]");
    private final By Logout_Button =By.xpath("//a[@href=\"/logout\"]");
    private final By Products_Button = By.xpath("//a[@href='/products']");
    private final By Cart_Button = By.xpath("//a[@href='/view_cart' and contains(text(), 'Cart')]");


    public P01_HomePage Continue_Button_AfterDeleteAccount(){
        Utilitiy.CLICKONELEMENTS(driver,Continue_Button_AfterDeleteAccount);
        return this;
    }
    public P07_ViewCartPage Cart_Button (){
        Utilitiy.CLICKONELEMENTS(driver,Cart_Button);
        return new P07_ViewCartPage(driver);
    }
    public P05_ProductsPage Products_Button (){
        Utilitiy.CLICKONELEMENTS(driver,Products_Button);
        return new P05_ProductsPage(driver);
    }
    public String Logged_as_Button () {
    return Utilitiy.GETTEXT(driver,Logged_as_Button);
}
    public String Deleted_Account_messege () {
        return Utilitiy.GETTEXT(driver,Deleted_Account_messege);
    }

    public P01_HomePage Logout_Button(){
        Utilitiy.CLICKONELEMENTS(driver,Logout_Button);
        return this;
    }
    public P01_HomePage Account_Delete_button (){
        Utilitiy.CLICKONELEMENTS(driver,Account_Delete_button);
        return this;
    }
    public P02_LoginPage Signup_login_button (){
        Utilitiy.CLICKONELEMENTS(driver,Signup_login_button);
        return new P02_LoginPage(driver);
    }
}
