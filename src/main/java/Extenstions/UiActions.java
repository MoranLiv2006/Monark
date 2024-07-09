package Extenstions;

import Utilities.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UiActions extends Base {

    public static void clickWebElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static String getTextFromElement(WebElement webElement, boolean scrollToElement) {
        if (scrollToElement) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webElement).build().perform();
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public static void scrollElementIntoView(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    public static void writeTextToElement(WebElement webElement, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }
}
