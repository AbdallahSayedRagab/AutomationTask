package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Utilitiy {
    public static void CLICKONELEMENTS(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Locator));
        driver.findElement(Locator).click();

    }

    public static void CLICKONVISIBLEELEMENTS(WebDriver driver, By Locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(Locator));
        driver.findElement(Locator).click();

    }

    public static void SENDKEYS(WebDriver driver, By Locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(Locator));
        driver.findElement(Locator).sendKeys(text);
    }

    public static void SELECT(WebDriver driver, By locator, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public static String GETTEXT(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    public static void HOVER(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).moveToElement(element).perform();
    }

    public static void SCREENSHOT (WebDriver driver ,String ImageName) throws IOException {
        String Path = System.getProperty("user.dir") + "/src/main/java/Shots/";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File(Path + ImageName + ".png");
        FileUtils.copyFile(src,target);
    }
    public static int COUNT(WebDriver driver, By locator) {
        List<WebElement> products = driver.findElements(locator);
        return products.size();
    }

}
