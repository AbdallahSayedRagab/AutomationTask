package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class P06_ProductDetails {
    private WebDriver driver;
    public P06_ProductDetails (WebDriver driver){
        this.driver= driver;
    }
    private final By Product_1_Name = By.xpath("//h2[contains(text(), 'Blue Top')]");
    private final By Product_1_Category = By.xpath("//p[contains(text(), 'Category')]");
    private final By Product_1_Price = By.xpath("//span[contains(text(), 'Rs')]");
    private final By Availability_of_Product1 = By.xpath("//p[contains(text(), ' In Stock')]");
    private final By Condition_of_Product1 = By.xpath("//p[contains(text(), ' New')]");
    private final By Brand_of_Product1 = By.xpath("//p[contains(text(), ' Polo')]");
    private final By Quantity_Of_product_Field = By.xpath("//input[@name=\"quantity\"]");
    private final By AddToCart_Of_ProductDetails_Button = By.xpath("//button[contains(normalize-space(), 'Add to cart')]");
    private final By Continue_Shopping_button = By.xpath("//button[contains(text() , 'Continue Shopping')]");


    public P06_ProductDetails Continue_Shopping_button(){
        Utilitiy.CLICKONELEMENTS(driver,Continue_Shopping_button);
        return this;
    }
    public P06_ProductDetails AddToCart_Of_ProductDetails_Button() throws IOException {
        Utilitiy.CLICKONELEMENTS(driver,AddToCart_Of_ProductDetails_Button);
        Utilitiy.SCREENSHOT(driver,"Product_1_Data");
        return this;
    }


    public P06_ProductDetails Quantity_Of_product_Field(){
        WebElement quantityField = driver.findElement(Quantity_Of_product_Field);
        quantityField.clear();
        Utilitiy.SENDKEYS(driver,Quantity_Of_product_Field,"4");
        return this;
    }

    public String  Product_1_Name()  {
       return Utilitiy.GETTEXT(driver,Product_1_Name);
    }
    public String Product_1_Category(){
        return Utilitiy.GETTEXT(driver,Product_1_Category);
    }
    public String Product_1_Price(){
        return Utilitiy.GETTEXT(driver,Product_1_Price);

    }
    public String Availability_of_Product1(){
        return Utilitiy.GETTEXT(driver,Availability_of_Product1);
    }
    public String Condition_of_Product1(){
        return  Utilitiy.GETTEXT(driver,Condition_of_Product1);
    }
    public String Brand_of_Product1(){
        return  Utilitiy.GETTEXT(driver,Brand_of_Product1);

    }
}
