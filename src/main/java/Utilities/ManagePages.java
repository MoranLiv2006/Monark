package Utilities;

import PageObjects.*;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initPages() {
        header = PageFactory.initElements(webDriver, Header.class);
        portfolio = PageFactory.initElements(webDriver, Portfolio.class);
        assetPage = PageFactory.initElements(webDriver, AssetPage.class);
        identity = PageFactory.initElements(webDriver, Identity.class);
        news = PageFactory.initElements(webDriver, News.class);
        contactUs = PageFactory.initElements(webDriver, ContactUs.class);
    }
}
