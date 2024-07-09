package Utilities;

import PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static Utilities.ManagePages.initPages;
import static io.restassured.RestAssured.given;

public class Base {

    //My contact information:
    private final String MY_NAME = "Moran Liv";
    private final String MY_EMAIL = "moran.liv2006@gmail.com";
    private final String MY_PHONE_NUMBER = "672-963-6730";

    //URLs:
    private final String MONARK_URL = "https://www.monark.com/";
    private final String CHUCK_NORRIS_API_URL = "https://api.chucknorris.io";

    //Selenium webDriver stuff:
    protected static WebDriver webDriver;
    protected static WebDriverWait webDriverWait;
    protected JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;

    //Web Page Objects:
    public static Header header;
    public static Portfolio portfolio;
    public static AssetPage assetPage;
    public static Identity identity;
    public static News news;
    public static ContactUs contactUs;

    //Rest assured stuff:
    protected Response response;
    protected JsonPath jsonPath;

    //Browser choice enum
    public enum BrowserTypes {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge");

        BrowserTypes(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    @BeforeClass
    public void SetupBeforeClass() {
        initBrowser(BrowserTypes.CHROME);
        initPages();
    }

    @AfterClass
    public void tearDownAfterClass() {
        webDriver.quit();
    }

    private void initBrowser(BrowserTypes browserTypes) {
        webDriver = initWebDriverInstance(browserTypes);
        webDriverWait = new WebDriverWait(webDriver, 10);

        webDriver.manage().window().maximize();
        webDriver.get(MONARK_URL);
    }

    private WebDriver initWebDriverInstance(BrowserTypes browserTypes) {
        System.out.println("Chosen browser: " + browserTypes.getValue());
        WebDriver driver = null;
        switch (browserTypes.getValue().toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
        }
        return driver;
    }

    public Response getRequestForAJoke() {
        response = given()
                .get(CHUCK_NORRIS_API_URL + "/jokes/random")
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public void delayForSeveralSeconds(int seconds) throws InterruptedException {
        if (seconds > 10)
            System.out.println("Delaying for " + seconds + " seconds");
        Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
    }

    public String getMY_NAME() {
        return MY_NAME;
    }

    public String getMY_EMAIL() {
        return MY_EMAIL;
    }

    public String getMY_PHONE_NUMBER() {
        return MY_PHONE_NUMBER;
    }
}
