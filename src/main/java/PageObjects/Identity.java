package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Identity {

    @FindBy(how = How.CSS, using = "div.container.about_container > h1")
    public WebElement txt_h1headline;

    @FindBy(how = How.CSS, using = "div.container.about_container > h2")
    public WebElement txt_h2headline;

    @FindBy(how = How.CSS, using = ".core-value-heading")
    public WebElement txt_coreValuesHeadline;

    @FindBy(how = How.CSS, using = "section.section.core-values.view > div > div > div > h3")
    public List<WebElement> list_coreValues;

    @FindBy(how = How.CLASS_NAME, using = "description_heading")
    public WebElement txt_aboutTitle;

    @FindBy(how = How.CSS, using = "section.section.description.view > div > p")
    public WebElement txt_aboutDescription;

    @FindBy(how = How.CSS, using = "div[class='founders_content'] img:nth-child(1)")
    public WebElement img_monty;

    @FindBy(how = How.CSS, using = "img[alt='Mark Catroppa - Executive Vice President & Co-Founder']")
    public WebElement img_mark;

    @FindBy(how = How.CSS, using = "div[class='founders_content'] h3:nth-child(1)")
    public WebElement txt_montyName;

    @FindBy(how = How.CSS, using = "div.founders_text.block_left > h3")
    public WebElement txt_markName;

    @FindBy(how = How.CSS, using = ".meet-the-team-heading")
    public WebElement txt_meetTheTeamTitle;

    @FindBy(how = How.CSS, using = "div.content-section.team > div > div:nth-child(2)")
    public WebElement table_team;

    @FindBy(how = How.CSS, using = "div[role='listitem'] > h2")
    public List<WebElement> list_restOfTheTeamNames;
}
