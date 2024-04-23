package survivals.highLevelTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.FAQPage;
import survivals.pages.HomePage;

public class HighLevelTest1 extends DriverFactory {

    @Test(priority = 1)
    @Description("KH-T16 Main page can be accessed from another interface with the logo in the footer")
    public void getFAQPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to FAQ page.
        homePage.clickFAQ();
        //2.Step: Navigate from FAQ page to home page with the logo in the footer.
        FAQPage faqPage = new FAQPage(driver, wait);
        faqPage.clickLogoInTheFooterAndBackToHomePage();
        //Checking
        //5.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}