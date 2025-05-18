package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_CheckOutPage {
    public WebDriver driver;

    public P08_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By Delivery_address = By.xpath("//*[@id=\"address_delivery\"]/li[4]");
    private final By Billing_address = By.xpath("//*[@id=\"address_invoice\"]/li[4]");
    private final By Comment = By.xpath("//textarea[@name=\"message\"]");
    private final By PlaceOrder_Button = By.xpath("//a[@href=\"/payment\"]");

    public String  Delivery_address (){
        return Utilitiy.GETTEXT(driver,Delivery_address);

    }
    public String  Billing_address (){
        return Utilitiy.GETTEXT(driver,Billing_address);

    }
    public P08_CheckOutPage Comment (){
        Utilitiy.SENDKEYS(driver,Comment,"Thank You");
        return this;
    }
    public P09_PaymentPage PlaceOrder_Button (){
        Utilitiy.CLICKONELEMENTS(driver,PlaceOrder_Button);
        return new P09_PaymentPage(driver);
    }
}