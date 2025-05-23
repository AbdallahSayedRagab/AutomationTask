package Pages;

import Utilities.DataUtils;
import Utilities.Utilitiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignUpPage {
    private WebDriver driver;
    public P03_SignUpPage(WebDriver driver) {
        this.driver = driver ;
    }
    private final By password = By.id("password");
    private final By firstname = By.id("first_name");
    private final By lastname = By.id("last_name");
    private final By address = By.id("address1");
    private final By country_list = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile_number = By.id("mobile_number");
    private final By create_account_button = By.xpath("//button[@data-qa=\"create-account\"]");


//    public String  get_address(){
//       return Utilitiy.GETTEXT(driver,address);
//    }
    public P04_AccountCreatedPage SignUp_Data (){
        String Password = DataUtils.getJsonData("Data", "Password");
        String firstName = DataUtils.getJsonData("Data", "First Name");
        String lastName = DataUtils.getJsonData("Data", "Last Name");
        String Address = DataUtils.getJsonData("Data", "Address");
        String country = DataUtils.getJsonData("Data", "Country");
        String State = DataUtils.getJsonData("Data", "State");
        String City = DataUtils.getJsonData("Data", "City");
        String zipCode = DataUtils.getJsonData("Data", "ZipCode");
        String number = DataUtils.getJsonData("Data", "Number");
        Utilitiy.SENDKEYS(driver,password,Password);
        Utilitiy.SENDKEYS(driver,firstname,firstName);
        Utilitiy.SENDKEYS(driver,lastname,lastName);
        Utilitiy.SENDKEYS(driver,address,Address);
        Utilitiy.SELECT(driver,country_list,country);
        Utilitiy.SENDKEYS(driver,state,State);
        Utilitiy.SENDKEYS(driver,city,City);
        Utilitiy.SENDKEYS(driver,zipcode,zipCode);
        Utilitiy.SENDKEYS(driver,mobile_number,number);
        Utilitiy.CLICKONELEMENTS(driver,create_account_button);

        return  new P04_AccountCreatedPage(driver);

    }



    }
//    public P03_SignUpPage password(String Password){
//        Utilitiy.SENDKEYS(driver,password,Password);
//        return this;
//    }
//    public P03_SignUpPage firstname(String First_name){
//        Utilitiy.SENDKEYS(driver,firstname,First_name);
//        return this;
//    }
//    public P03_SignUpPage lastname(String Last_name){
//        Utilitiy.SENDKEYS(driver,lastname,Last_name);
//        return this;
//    }
//    public P03_SignUpPage address(String Address){
//        Utilitiy.SENDKEYS(driver,address,Address);
//        return this;
//    }
//    public P03_SignUpPage country_list(String Country){
//        Utilitiy.SELECT(driver,country_list,Country);
//        return this;
//    }
//    public P03_SignUpPage state(String State){
//        Utilitiy.SENDKEYS(driver,state,State);
//        return this;
//    }
//    public P03_SignUpPage city(String City){
//        Utilitiy.SENDKEYS(driver,city,City);
//        return this;
//    }
//    public P03_SignUpPage zipcode(String Zipcode){
//        Utilitiy.SENDKEYS(driver,zipcode,Zipcode);
//        return this;
//    }
//    public P03_SignUpPage mobile_number(String Number){
//        Utilitiy.SENDKEYS(driver,mobile_number,Number);
//        return this;
//    }
//    public P03_SignUpPage create_account_button(){
//        Utilitiy.CLICKONELEMENTS(driver,create_account_button);
//        return new P03_SignUpPage(driver);
//    }
//
//}
