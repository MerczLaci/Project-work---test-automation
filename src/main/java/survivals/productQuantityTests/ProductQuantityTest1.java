package survivals.productQuantityTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.*;

/*
Comment about products:
Product1-P�ros �lm�nyek-Kapar�s Aj�nd�k P�roknak
Product2-Kapar�s Kincskeres� T�rk�p Gyerekeknek
Product3-Kapar�s Adventi Napt�r Gyerekeknek
 */

public class ProductQuantityTest1 extends DriverFactory {
    @Test(priority = 1)
    @Description("KH-T40 Product quantity input with lower limit numerical data")
    public void fillProductQuantityWithLowerLimitData () throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //2.Step: Select product and navigate to the product page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct3Name();
        //3.Step: Fill in the quantity input field filled with lower limit numerical data
        Product3Page product3Page = new Product3Page(driver, wait);
        product3Page.clearTheQuantityInputField();
        product3Page.fillInTheQuantityInputField("1");
        //4.Step: Put the product into the cart.
        product3Page.clickPutInTheCartButton();
        //5.Step: Navigate to the cart from the popup window.
        product3Page.clickCartButton();
        //Checking
        CartPage cartPage = new CartPage(driver, wait);
        //6.Step: Checking the cart with the product.
        Assert.assertTrue(cartPage.getProductTitle());
        //7.Step: Checking the price.
        Assert.assertEquals(cartPage.getPriceAmount(), "R�sz�sszeg 4.490 Ft");
    }
}
