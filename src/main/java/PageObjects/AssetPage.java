package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AssetPage {

    @FindBy(how = How.CSS, using = ".page_header")
    public WebElement title_projectName;

    @FindBy(how = How.CSS, using = ".page_text_heading")
    public WebElement txt_assetTitle;

    @FindBy(how = How.CSS, using = "div[class='page_text_description w-richtext'] p:nth-child(1)")
    public WebElement txt_assetDescription;
}
