package survivals.highLevelTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.HomePage;
import survivals.pages.Product2Page;
import survivals.pages.ProductsPage;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
 */

public class HighLevelTest2 extends DriverFactory {

    @Test(priority = 1)
    @Description("KH-T24 Use 'Products' menu point and select a product with it's image")
    public void useProductsMenuPointAndSelectProductWithImage() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        homePage.clickProducts();
        //2.Step: Select product2 and navigate to product2Page with product2's image.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct2Image();
        //Checking
        //5.Step: Checking that home page loaded again.
        Product2Page product2Page = new Product2Page(driver, wait);
        Assert.assertEquals(product2Page.getProduct2Name(), "Kaparós Kincskeresõ Térkép Gyerekeknek");
    }
}