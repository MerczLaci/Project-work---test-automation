package survivals.menuPointTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.HomePage;
import survivals.pages.ProductsPage;

public class ProductsPageTests extends DriverFactory {

    @Test(priority = 1)
    @Description("Main page can be accessed from products page with the logo in the header")
    public void getProductsPageAndNavigateBackToHomePage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //2.Step: Navigate from products page back to home page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickLogoAndBackToHomePage();
        //Checking
        //3.Step: Checking that home page loaded again.
        Assert.assertEquals(homePage.getWelcomeText(), "KAPAR�S KALANDOK VIL�G�BAN!");
    }
}
