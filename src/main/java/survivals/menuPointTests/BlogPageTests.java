package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.BlogPage;
import survivals.pages.HomePage;

public class BlogPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from blog page with the logo in the header")
    public void getBlogPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to blog page.
        homePage.clickBlog();
        //2.Step: Navigate from blog page back to home page.
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPARÓS KALANDOK VILÁGÁBAN!");
    }
}
