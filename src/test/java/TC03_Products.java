import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Locale;

public class TC03_Products {
    private WebDriver driver ;
    @BeforeMethod
    public void setupdriver (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    public void View_Products(){
        new P01_HomePage(driver).Products_Button();
        P05_ProductsPage Title_Of_Page = new P05_ProductsPage(driver);
        Assert.assertEquals(Title_Of_Page.All_Product_Title(),"All Products");
        new P05_ProductsPage(driver).View_product_1();
        new P06_ProductDetails(driver).Product_1_Name().Product_1_Price()
                .Availability_of_Product1().Condition_of_Product1().Product_1_Category();
     }

    @Test
    public void Search_Products() throws IOException {
        new P01_HomePage(driver).Products_Button();
        P05_ProductsPage Title_Of_Page = new P05_ProductsPage(driver);
        Assert.assertEquals(Title_Of_Page.All_Product_Title(),"ALL PRODUCTS");
        new P05_ProductsPage(driver).Search_bar().Search_Submit();

    }
    @Test
    public void Add_Products() throws IOException {
        new P01_HomePage(driver).Products_Button();
        new P05_ProductsPage(driver).AddToCart_1_Button().Continue_Shopping_button()
             .AddToCart_2_Button().View_Cart_Button();
//        P07_ViewCartPage Price = new P07_ViewCartPage(driver);
       String g = new P07_ViewCartPage(driver).get_their_price();
       String f = new P07_ViewCartPage(driver).get_total_quantity();
       String d = new P07_ViewCartPage(driver).get_total_price();
       Assert.assertEquals(g,"900.0");
       Assert.assertEquals(f,"2.0");
       Assert.assertEquals(d,"100");

    }
    @Test
    public void Add_Quantity_Of_Products() throws IOException {
        new P01_HomePage(driver).Products_Button();
        new P05_ProductsPage(driver).View_product_1();
        new P06_ProductDetails(driver).Quantity_Of_product_Field()
                .AddToCart_Of_ProductDetails_Button().Continue_Shopping_button();
        new P01_HomePage(driver).Cart_Button();
        new P07_ViewCartPage(driver).get_total_quantity();
        String h = new P07_ViewCartPage(driver).get_quantity();
        Assert.assertEquals(h,"2.0");



    }
    @Test
    public void Checkout () {
        new P01_HomePage(driver).Signup_login_button();
        new P02_LoginPage(driver).Login_Email("Abwdarrerla@coc.net")
                .Login_Password("Abdallah@123").Login_button();
        P01_HomePage Logged_visability = new P01_HomePage(driver);
        Assert.assertEquals(Logged_visability.Logged_as_Button(), "Logged in as AbdallahSayed");
        new P05_ProductsPage(driver).AddToCart_1_Button().Continue_Shopping_button()
                .AddToCart_2_Button().View_Cart_Button().ProccedToCheckout_Button();
        new P08_CheckOutPage(driver).Comment().PlaceOrder_Button();
        new P09_PaymentPage(driver).Name_on_Card().Card_Number()
                .CVC().Expiration_M().Expiration_Y().ConfirmOrder_button();
        new P01_HomePage(driver).Account_Delete_button();
        Assert.assertEquals(Logged_visability.Deleted_Account_messege(), "ACCOUNT DELETED!");
    }
    @Test
    public void View_Category_Products (){
        new P01_HomePage(driver).Products_Button();
        P05_ProductsPage category = new P05_ProductsPage(driver);
        Assert.assertEquals(category.Category_List(),"CATEGORY");
        new P05_ProductsPage(driver).Women_Category().Dress().Men_Category().TShirts();
        String CurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL, "https://automationexercise.com/category_products/2");

    }
    @Test
    public void View_Brand_Products (){
        new P01_HomePage(driver).Products_Button();
        P05_ProductsPage Brand = new P05_ProductsPage(driver);
        Assert.assertEquals(Brand.Brand_List(),"BRANDS");
        new P05_ProductsPage(driver).Allen_Solly_Junior();
        String CurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL, "https://automationexercise.com/brand_products/Allen%20Solly%20Junior");
        P05_ProductsPage NUM_OF_PRODUCT = new P05_ProductsPage(driver);
        Assert.assertEquals(NUM_OF_PRODUCT.ProductsOfAllenSollyJunior(),3);
        new P05_ProductsPage(driver).Polo();
        String CurrentURL2 = driver.getCurrentUrl();
        Assert.assertEquals(CurrentURL2, "https://automationexercise.com/brand_products/Polot");

    }

//    @Test
//    public void Add_Products() throws IOException {
//        new P01_HomePage(driver).Products_Button();
//        new P05_ProductsPage(driver).P1_Image_hover().AddToCart_1_Button().Continue_Shopping_button()
//                .P2_Image_hover().AddToCart_2_Button().View_Cart_Button();
////        P07_ViewCartPage Price = new P07_ViewCartPage(driver);
//        new P07_ViewCartPage(driver).get_total_price();
//
//
//    }



//    @AfterMethod
//    public void quit(){
//        driver.quit();
//    }
}
