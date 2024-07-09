package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class News {

    @FindBy(how = How.XPATH, using = "//div[@role='listitem']//a[@class='blog_post_link link_item w-inline-block']//img")
    public List<WebElement> list_images;

    @FindBy(how = How.XPATH, using = "//div[@role='listitem']//a[@class='blog_post_link link_item w-inline-block']//h2")
    public List<WebElement> list_imagesText;
}
