package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Portfolio {

    @FindBy(how = How.CSS, using = "div.container.projects_container > h1")
    public WebElement txt_h1headline;

    @FindBy(how = How.CSS, using = "div.container.projects_container > h2")
    public WebElement txt_h2headline;

    @FindBy(how = How.CSS, using = "div[class='case-study_list case-study_grid container w-dyn-items'] div[role='listitem'] div[class='case-study_img grid'] img")
    public List<WebElement> list_assetsImageList;

    @FindBy(how = How.CSS, using = "div[class='case-study_list case-study_grid container w-dyn-items'] div[role='listitem'] div[class='case-study_text grid'] h2")
    public List<WebElement> list_assetsNamesList;
}