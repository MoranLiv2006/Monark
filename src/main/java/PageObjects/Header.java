package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {

    @FindBy(how = How.CSS, using = "aside > a:nth-child(1)")
    public WebElement btn_portfolio;

    @FindBy(how = How.CSS, using = "aside > a:nth-child(2)")
    public WebElement btn_identity;

    @FindBy(how = How.CSS, using = "aside > a:nth-child(3)")
    public WebElement btn_career;

    @FindBy(how = How.CSS, using = "aside > a:nth-child(4)")
    public WebElement btn_news;

    @FindBy(how = How.CSS, using = "div[class='btn_text']")
    public WebElement btn_ContactUs;
}
