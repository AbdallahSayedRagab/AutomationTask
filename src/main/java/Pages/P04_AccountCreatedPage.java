package Pages;

import Utilities.Utilitiy;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class P04_AccountCreatedPage {
        private WebDriver driver;
       public P04_AccountCreatedPage(WebDriver driver) {
        this.driver = driver ;
    }
    private final By account_created_messege = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By continue_button = By.xpath("//a[@data-qa=\"continue-button\"]");

    public String accountCreated_messege(){
      return Utilitiy.GETTEXT(driver,account_created_messege);
    }



    public P01_HomePage continue_button(){
    Utilitiy.CLICKONELEMENTS(driver,continue_button);
        return new P01_HomePage(driver);
    }

}
