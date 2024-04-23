package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.HomePage;
import survivals.pages.TermsOfPurchasePage;

public class TermsOfPurchasePageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from terms of purchase page with the logo in the header")
    public void getTermsOfPurchasePageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to terms of purchase page.
        homePage.clickTermsOfPurchase();
        //2.Step: Navigate from terms of purchase page back to home page.
        TermsOfPurchasePage termsOfPurchasePage = new TermsOfPurchasePage(driver);
        termsOfPurchasePage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
