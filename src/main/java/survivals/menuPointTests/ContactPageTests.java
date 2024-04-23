package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.ContactPage;
import survivals.pages.HomePage;

public class ContactPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from contact page with the logo in the header")
    public void getContactPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to contact page.
        homePage.clickContact();
        //2.Step: Navigate from contact page back to home page.
        ContactPage contactPage = new ContactPage(driver);
        contactPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
