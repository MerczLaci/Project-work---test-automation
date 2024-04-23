package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.GeneralTermsAndConditionsPage;
import survivals.pages.HomePage;

public class GeneralTermsAndConditionsPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from general terms and conditions page with the logo in the header")
    public void getGeneralTermsAndConditionsPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to general terms and conditions page.
        homePage.clickGeneralTermsAndConditions();
        //2.Step: Navigate from general terms and conditions page back to home page.
        GeneralTermsAndConditionsPage generalTermsAndConditionsPage = new GeneralTermsAndConditionsPage(driver);
        generalTermsAndConditionsPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
