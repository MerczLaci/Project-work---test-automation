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

public class ProductCartTest2 extends DriverFactory {

    @Test(priority = 1)
    @Description("KH-T2 Product selection and placing in the cart then deleting the product from the cart")
    public void selectProductAndPlaceInCartThenDeleteTheProduct() throws InterruptedException {
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
        //5.Step: Delete the product from the cart.
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickXDeleteButton();
        //Checking
        //6.Step: Checking the cart.
        Assert.assertEquals(cartPage.getCartEmptyText(), "Jelenleg �res a bev�s�rl�kos�r.");
    }
}
