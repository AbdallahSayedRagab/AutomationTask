package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07_ViewCartPage {
    public WebDriver driver;

    public P07_ViewCartPage(WebDriver driver) {
        this.driver = driver;
    }

    static float TheirPrice = 0;
    static float TotalPrice = 0;
    static float TotalQuantity = 0;
    static float Quantity = 0;

    private final By PricesOfSeletedProductsLocator = By.xpath("//tr[starts-with(@id,'product-')]//td[@class='cart_price']/p");
    private final By QuantityOfSeletedProductsLocator = By.xpath("//tr[starts-with(@id,'product-')]//td[@class='cart_quantity']/button");
    private final By TotalPricesOfSeletedProductsLocator = By.xpath("//tr[starts-with(@id,'product-')]//td[@class='cart_total']/p");
    private final By ProccedToCheckout_Button = By.xpath("//a[contains(text() , 'Proceed To Checkout')]");
    private final By RegisterOrLogin_Button = By.xpath("//a[@href=\"/login\" and u[contains(text(), 'Register / Login')]]");

    public  P02_LoginPage RegisterOrLogin_Button (){
        Utilitiy.CLICKONELEMENTS(driver,RegisterOrLogin_Button);
        return new P02_LoginPage(driver);
    }
    public  P08_CheckOutPage ProccedToCheckout_Button (){
        Utilitiy.CLICKONELEMENTS(driver,ProccedToCheckout_Button);
        return new P08_CheckOutPage(driver);
    }

    public String get_their_price() {
        try {

            List<WebElement> PricesOfSelectedProduct = driver.findElements(PricesOfSeletedProductsLocator);
            for (int i = 1; i <= PricesOfSelectedProduct.size(); i++) {
                By Elements = By.xpath("(//tr[starts-with(@id,'product-')])[" + i + "]//td[@class='cart_price']/p");
                String Fulltext = Utilitiy.GETTEXT(driver, Elements);
                TheirPrice += Float.parseFloat(Fulltext.replace("Rs. ", ""));
            }
            return String.valueOf(TheirPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    public String get_total_quantity() {
        try {

            List<WebElement> QuantityOfSelectedProduct = driver.findElements(QuantityOfSeletedProductsLocator);
            for (int i = 1; i <= QuantityOfSelectedProduct.size(); i++) {
                By Elements = By.xpath("(//tr[starts-with(@id,'product-')])[" + i + "]//td[@class='cart_quantity']/button");
                String Fulltext = Utilitiy.GETTEXT(driver, Elements);
                TotalQuantity += Float.parseFloat(Fulltext);
            }
            return String.valueOf(TotalQuantity);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }
    public String get_quantity() {
        try {

            List<WebElement> QuantityOfSelectedProduct = driver.findElements(QuantityOfSeletedProductsLocator);
            for (int i = 1; i <= QuantityOfSelectedProduct.size(); i++) {
                By Elements = By.xpath("(//tr[starts-with(@id,'product-')])[" + i + "]//td[@class='cart_quantity']/button");
                String Fulltext = Utilitiy.GETTEXT(driver, Elements);
                Quantity = Float.parseFloat(Fulltext);
            }
            return String.valueOf(TotalQuantity);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    public String get_total_price() {
        try {

            List<WebElement> TotalPricesOfSeletedProducts = driver.findElements(TotalPricesOfSeletedProductsLocator);
            for (int i = 1; i <= TotalPricesOfSeletedProducts.size(); i++) {
                By Elements = By.xpath("(//tr[starts-with(@id,'product-')])[" + i + "]//td[@class='cart_total']/p");
                String Fulltext = Utilitiy.GETTEXT(driver, Elements);
                TotalPrice += Float.parseFloat(Fulltext.replace("Rs. ", ""));
            }
            return String.valueOf(TotalPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}

