package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.FAQPage;
import survivals.pages.HomePage;

public class FAQPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from FAQ page with the logo in the header")
    public void getFAQPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to FAQ page.
        homePage.clickFAQ();
        //2.Step: Navigate from FAQ page back to home page.
        FAQPage faqPage = new FAQPage(driver, wait);
        faqPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
