package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.HomePage;
import survivals.pages.PrivacyPolicyPage;

public class PrivacyPolicyPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from privacy policy page with the logo in the header")
    public void getPrivacyPolicyPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to privacy policy page.
        homePage.clickPrivacyPolicy();
        //2.Step: Navigate from privacy policy page back to home page.
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driver);
        privacyPolicyPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
