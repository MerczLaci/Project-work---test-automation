package survivals.productCartTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.CartPage;
import survivals.pages.HomePage;
import survivals.pages.Product2Page;
import survivals.pages.ProductsPage;

/*
Comment about products:
Product1-P�ros �lm�nyek-Kapar�s Aj�nd�k P�roknak
Product2-Kapar�s Kincskeres� T�rk�p Gyerekeknek
Product3-Kapar�s Adventi Napt�r Gyerekeknek
 */

public class ProductCartTest1 extends DriverFactory {

    @Test(priority = 1)
    @Description("KH-T1 Product selection and placing in cart")
    public void selectProductAndPlaceInCart() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //2.Step: Select product and navigate to the product page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct2Name();
        //3.Step: Put the product into the cart.
        Product2Page product2Page = new Product2Page(driver, wait);
        product2Page.clickPutInTheCartButton();
        //4.Step: Navigate to the cart from the popup window.
        product2Page.clickCartButton();
        //Checking
        CartPage cartPage = new CartPage(driver, wait);
        //5.Step: Checking the cart with the product.
        Assert.assertTrue(cartPage.getProductTitle());
        //6.Step: Checking the price.
        Assert.assertEquals(cartPage.getPriceAmount(), "R�sz�sszeg 5.990 Ft");
    }
}
