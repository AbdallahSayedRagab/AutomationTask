package Pages;

import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class P05_ProductsPage {
    public WebDriver driver ;
    public P05_ProductsPage(WebDriver driver) {
        this.driver = driver ;
    }
    private final By View_product_1 = By.xpath("//a[@href='/product_details/1']");
    private final By All_Product_Title = By.xpath("//h2[contains(text(), 'All Products')]");
    private final By Search_bar = By.id("search_product");
    private final By Search_Submit = By.id("submit_search");
    private final By P1_Image = By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private final By P2_Image = By.xpath("//img[@src=\"/get_product_picture/2\"]");
    private final By AddToCart_1_Button = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    private final By Continue_Shopping_button = By.xpath("//button[contains(text() , 'Continue Shopping')]");
    private final By AddToCart_2_Button = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    private final By View_Cart_Button = By.xpath("//u[contains(text() , 'View Cart')]");
    private final By Category_List = By.xpath("//h2[contains(text(), 'Category')]");
    private final By Women_Category = By.xpath("//a[@href=\"#Women\"]");
    private final By Dress = By.xpath("//a[@href=\"/category_products/1\"]");
    private final By Men_Category = By.xpath("//a[@href=\"#Men\"]");
    private final By TShirts = By.xpath("//a[@href=\"/category_products/3\"]");
    private final By Brand_List = By.xpath("//h2[contains(text(), 'Brands')]");
    private final By Allen_Solly_Junior = By.xpath("//a[@href=\"/brand_products/Allen Solly Junior\"]");
    private final By ProductsOfAllenSollyJunior = By.xpath("//div[@class=\"product-image-wrapper\"]");
    private final By Polo = By.xpath("//a[@href=\"/brand_products/Polo\"]");




    public  P05_ProductsPage Polo (){
        Utilitiy.CLICKONELEMENTS(driver,Polo);
        return this;
    }
    public int ProductsOfAllenSollyJunior () {
        return Utilitiy.COUNT(driver,ProductsOfAllenSollyJunior);
    }

    public  P05_ProductsPage Allen_Solly_Junior (){
        Utilitiy.CLICKONELEMENTS(driver,Allen_Solly_Junior);
        return this;
    }
    public String Brand_List () {
        return Utilitiy.GETTEXT(driver,Brand_List);
    }


    public  P05_ProductsPage TShirts (){
        Utilitiy.CLICKONELEMENTS(driver,TShirts);
        return this;
    }
    public  P05_ProductsPage Men_Category (){
        Utilitiy.CLICKONELEMENTS(driver,Men_Category);
        return this;
    }

    public  P05_ProductsPage Dress (){
        Utilitiy.CLICKONELEMENTS(driver,Dress);
        return this;
    }
    public  P05_ProductsPage Women_Category (){
        Utilitiy.CLICKONELEMENTS(driver,Women_Category);
        return this;
    }
    public String Category_List () {
        return Utilitiy.GETTEXT(driver,Category_List);
    }

    public  P07_ViewCartPage View_Cart_Button (){
        Utilitiy.CLICKONELEMENTS(driver,View_Cart_Button);
        return new  P07_ViewCartPage(driver);
    }
    public P05_ProductsPage AddToCart_2_Button (){
        Utilitiy.CLICKONELEMENTS(driver,AddToCart_2_Button);
        return this;
    }
    public P05_ProductsPage Continue_Shopping_button(){
        Utilitiy.CLICKONELEMENTS(driver , Continue_Shopping_button);
        return this;
    }
    public P05_ProductsPage P2_Image_hover(){
        Utilitiy.HOVER(driver ,P2_Image);
        return this;
    }
    public P05_ProductsPage P1_Image_hover(){
        Utilitiy.HOVER(driver ,P1_Image);
        return this;
    }
    public P05_ProductsPage AddToCart_1_Button (){
        Utilitiy.CLICKONELEMENTS(driver,AddToCart_1_Button);
        return this;
    }
    public P05_ProductsPage View_product_1 (){
        Utilitiy.CLICKONELEMENTS(driver,View_product_1);
        return this;
    }

    public P05_ProductsPage Search_bar (){
        Utilitiy.SENDKEYS(driver,Search_bar,"Men Tshirt");
        return this;
    }
    public P05_ProductsPage Search_Submit () throws IOException {
        Utilitiy.CLICKONELEMENTS(driver,Search_Submit);
        Utilitiy.SCREENSHOT(driver,"ScreenShotOnFunction");
        return this;
    }
    public String All_Product_Title () {
        return Utilitiy.GETTEXT(driver,All_Product_Title);
    }


}
