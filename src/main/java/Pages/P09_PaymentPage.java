package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_PaymentPage {
    public WebDriver driver;

    public P09_PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By Name_on_Card = By.xpath("//input[@name=\"name_on_card\"]");
    private final By Card_Number = By.xpath("//input[@name=\"card_number\"]");
    private final By CVC = By.xpath("//input[@name=\"cvc\"]");
    private final By Expiration_M = By.xpath("//input[@name=\"expiry_month\"]");
    private final By Expiration_Y = By.xpath("//input[@name=\"expiry_year\"]");
    private final By ConfirmOrder_button = By.xpath("//button[@data-qa=\"pay-button\"]");
    private final By Success_Payment_Messege = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    private final By DownloadInvoice_Button = By.xpath("//a[@href=\"/download_invoice/900\"]");
    private final By Continue_AfterPaying = By.xpath("//a[@data-qa=\"continue-button\"]");



    public P09_PaymentPage Continue_AfterPaying (){
        Utilitiy.CLICKONELEMENTS(driver,Continue_AfterPaying);
        return this;
    }
    public P09_PaymentPage DownloadInvoice_Button (){
        Utilitiy.CLICKONELEMENTS(driver,DownloadInvoice_Button);
        return this;
    }
    public String  Success_Payment_Messege (){
        return Utilitiy.GETTEXT(driver,Success_Payment_Messege);
    }
    public P09_PaymentPage Name_on_Card (){
        Utilitiy.SENDKEYS(driver,Name_on_Card,"Abdallah");
        return this;
    }
    public P09_PaymentPage Card_Number (){
        Utilitiy.SENDKEYS(driver,Card_Number,"3000300030003000");
        return this;
    }
    public P09_PaymentPage CVC (){
        Utilitiy.SENDKEYS(driver,CVC,"123");
        return this;
    }
    public P09_PaymentPage Expiration_M (){
        Utilitiy.SENDKEYS(driver,Expiration_M,"11");
        return this;
    }
    public P09_PaymentPage Expiration_Y (){
        Utilitiy.SENDKEYS(driver,Expiration_Y,"2025");
        return this;
    }
    public P09_PaymentPage ConfirmOrder_button (){
        Utilitiy.CLICKONELEMENTS(driver,ConfirmOrder_button);
        return this;
    }


}
