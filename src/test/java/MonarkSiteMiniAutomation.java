import Extenstions.ApiActions;
import Extenstions.UiActions;
import Extenstions.Verifications;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MonarkSiteMiniAutomation extends Utilities.Base {

    private Verifications verifications;

    @BeforeMethod
    public void setupBeforeMethod() {
        verifications = new Verifications();
    }

    @Test
    public void portfolioPageAutomation() {
        UiActions.clickWebElement(header.btn_portfolio);

        //Verifying the headline text is display and accurate
        verifications.verifyElementIsDisplayedAndEnabled(portfolio.txt_h1headline);
        Assert.assertEquals(UiActions.getTextFromElement(portfolio.txt_h2headline, false),
                "Highlighting our diverse portfolio spanning global shipping logistics, health technology, " +
                        "and real estate development. Each project underscores our commitment to innovation, " +
                        "quality, and strategic growth across various industries.");
        verifications.verifyElementTextIsNotNullAndPrintIt(portfolio.txt_h2headline);

        //Verifying all the assets images are display
        for (WebElement assetImage : portfolio.list_assetsImageList) {
            verifications.verifyElementIsDisplayedAndEnabled(assetImage);
        }

        //Loop that runs on each asset and checks:
        for (int i = 0; i < portfolio.list_assetsNamesList.size(); i++) {
            //that asset name display and not null
            verifications.verifyElementIsDisplayedAndEnabled(portfolio.list_assetsNamesList.get(i));
            verifications.verifyElementTextIsNotNullAndPrintIt(portfolio.list_assetsNamesList.get(i), true);
            String assetName = UiActions.getTextFromElement(portfolio.list_assetsNamesList.get(i), false);
            UiActions.clickWebElement(portfolio.list_assetsNamesList.get(i));

            //that the asset project equal to the asset name
            Assert.assertEquals(UiActions.getTextFromElement(assetPage.title_projectName, false),
                    assetName);

            //that each asset has title and description
            verifications.verifyElementTextIsNotNullAndPrintIt(assetPage.txt_assetTitle);
            verifications.verifyElementTextIsNotNullAndPrintIt(assetPage.txt_assetDescription);

            //that the asset description is not null may contain the project name
            if (UiActions.getTextFromElement(assetPage.txt_assetDescription, true).
                    contains(UiActions.getTextFromElement(assetPage.txt_assetTitle, true))) {
                Assert.assertTrue(UiActions.getTextFromElement(assetPage.txt_assetDescription, true).
                        contains(UiActions.getTextFromElement(assetPage.txt_assetTitle, true)));
                System.out.println("Description contains the project name");
            }
            verifications.verifyElementTextIsNotNullAndPrintIt(assetPage.txt_assetDescription);

            //back to the portfolio page for the next asset in line
            UiActions.clickWebElement(header.btn_portfolio);
            verifications.verifyListIsLoadedCorrectly(portfolio.list_assetsNamesList);
            verifications.verifyListIsLoadedCorrectly(portfolio.list_assetsImageList);
        }
    }

    @Test
    public void identityPageAutomation() {
        UiActions.clickWebElement(header.btn_identity);

        //Verifying the headline text is display and accurate
        verifications.verifyElementIsDisplayedAndEnabled(identity.txt_h1headline);
        Assert.assertEquals(UiActions.getTextFromElement(identity.txt_h2headline, false),
                "Monark Ventures, a dynamic and multifaceted company dedicated to pioneering innovative " +
                        "solutions in today’s fast-paced business world.");
        verifications.verifyElementTextIsNotNullAndPrintIt(identity.txt_h2headline);

        //Verifying the core values part
        System.out.println("\n");
        verifications.verifyElementIsDisplayedAndEnabled(identity.txt_coreValuesHeadline);
        UiActions.scrollElementIntoView(identity.txt_coreValuesHeadline);
        verifications.verifyListIsLoadedCorrectly(identity.list_coreValues);
        System.out.println("'Monark' values are:");
        for (int i = 0; i < identity.list_coreValues.size(); i++) {
            System.out.print(i + 1 + ":");
            verifications.verifyElementTextIsNotNullAndPrintIt(identity.list_coreValues.get(i));
        }

        //About Monark
        UiActions.scrollElementIntoView(identity.txt_aboutTitle);
        verifications.verifyElementIsDisplayedAndEnabled(identity.txt_aboutTitle);
        verifications.verifyElementTextIsNotNullAndPrintIt(identity.txt_aboutDescription);

        //Verifying the founders images and name are correct
        UiActions.scrollElementIntoView(identity.img_monty);
        verifications.verifyElementIsDisplayedAndEnabled(identity.img_monty);
        verifications.verifyElementTextIsNotNullAndPrintIt(identity.txt_montyName);
        Assert.assertEquals(UiActions.getTextFromElement(identity.txt_montyName, false),
                "Monty Sikka");
        UiActions.scrollElementIntoView(identity.img_mark);
        verifications.verifyElementIsDisplayedAndEnabled(identity.img_mark);
        verifications.verifyElementTextIsNotNullAndPrintIt(identity.txt_markName);
        Assert.assertEquals(UiActions.getTextFromElement(identity.txt_markName, false),
                "Mark Catroppa");

        //Scrolling to the rest of the team section
        UiActions.scrollElementIntoView(identity.txt_meetTheTeamTitle);
        verifications.verifyElementIsDisplayedAndEnabled(identity.txt_meetTheTeamTitle);
        System.out.println("\nRest of the team: ");

        for (WebElement webElement : identity.list_restOfTheTeamNames) {
            verifications.verifyElementTextIsNotNullAndPrintIt(webElement, true);
        }
    }

    @Test
    public void newsPageAutomation() {
        UiActions.clickWebElement(header.btn_news);

        //Verifying all the image are displayed and enabled
        verifications.verifyListIsLoadedCorrectly(news.list_images);
        for (WebElement webElement : news.list_images) {
            Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(webElement));
        }

        //Verifying the text under the images is not null and displaying it
        for (WebElement webElement : news.list_imagesText) {
            verifications.verifyElementTextIsNotNullAndPrintIt(webElement);
        }
    }

    @Test(priority = 4)
    public void contactUsPageAutomation() throws InterruptedException {
        ApiActions apiActions = new ApiActions();
        UiActions.clickWebElement(header.btn_ContactUs);

        //Verifying all the input fields are displayed and enabled
        Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(contactUs.input_name));
        Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(contactUs.input_email));
        Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(contactUs.input_phoneNumber));
        Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(contactUs.input_company));
        Assert.assertTrue(verifications.verifyElementIsDisplayedAndEnabled(contactUs.input_message));

        //Writing down my contact information in the input fields
        UiActions.writeTextToElement(contactUs.input_name, getMY_NAME());
        UiActions.writeTextToElement(contactUs.input_email, getMY_EMAIL());
        UiActions.writeTextToElement(contactUs.input_phoneNumber, getMY_PHONE_NUMBER());
        UiActions.writeTextToElement(contactUs.input_company, "Currently unemployed, hopefully soon at 'Monark' :)");

        String messageText =
                "Hi, my name is Moran Liv and I'm a QA Automation engineer with almost 4 years of experience.\n" +
                        "I've made this simple automation on 'Monark' website to demonstrate my automation skills.\n" +
                        "Here is a 'Chuck Norris joke' for a funny closer: \n";
        UiActions.writeTextToElement(contactUs.input_message, messageText + apiActions.getChuckNorrisJoke() + "\n\n" +
                "Would love to hear back from you.\nMoran Liv");
        delayForSeveralSeconds(11);
    }
}

