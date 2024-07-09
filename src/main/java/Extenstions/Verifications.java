package Extenstions;

import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Verifications extends Base {

    public boolean verifyElementIsDisplayedAndEnabled(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed() && webElement.isEnabled();
    }

    public void verifyElementTextIsNotNullAndPrintIt(WebElement webElement) {
        verifyElementTextIsNotNullAndPrintIt(webElement, false);
    }

    public void verifyElementTextIsNotNullAndPrintIt(WebElement webElement, boolean scrollToElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        Assert.assertNotNull(UiActions.getTextFromElement(webElement, scrollToElement));
        System.out.println(UiActions.getTextFromElement(webElement, scrollToElement));
    }

    public void verifyListIsLoadedCorrectly(List<WebElement> webElementList) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
        Assert.assertNotEquals(webElementList.size(), 0);
    }
}
