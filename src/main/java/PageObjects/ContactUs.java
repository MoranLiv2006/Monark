package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUs {

    @FindBy(how = How.ID, using = "name")
    public WebElement input_name;

    @FindBy(how = How.ID, using = "email")
    public WebElement input_email;

    @FindBy(how = How.ID, using = "Phone-Number")
    public WebElement input_phoneNumber;

    @FindBy(how = How.ID, using = "Company")
    public WebElement input_company;

    @FindBy(how = How.CSS, using = "#field")
    public WebElement input_message;
}
