package survivals.productCartTests;

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

public class ProductCartTest4 extends DriverFactory {

    @Test(priority = 1)
    @Description("KH-T4 Product selection and placing in cart then selecting another product and placing it in the cart too")
    public void selectProductAndPlaceInCartAndSelectAnotherProductAndPlaceInCart() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //2.Step: Select product2 and navigate to the product2 page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct2Name();
        //3.Step: Put the product2 into the cart.
        Product2Page product2Page = new Product2Page(driver, wait);
        product2Page.clickPutInTheCartButton();
        //4.Step: Navigate to the cart from the popup window.
        product2Page.clickCartButton();
        //5.Step: Navigate from cart page to products page.
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickProducts();
        //6.Step: Select product3 and navigate to the product3 page.
        productsPage.clickProduct3Name();
        //7.Step: Put the product3 into the cart.
        Product3Page product3Page = new Product3Page(driver, wait);
        product3Page.clearTheQuantityInputField();
        product3Page.fillInTheQuantityInputField("1");
        driver.navigate().refresh();
        Thread.sleep(5000);
        product3Page.clickPutInTheCartButton();
        //8.Step: Navigate to the cart from the popup window.
        product3Page.clickCartButton();
        //Checking
        //9.Step: Checking the cart with products.
        Assert.assertEquals(cartPage.getFirstProductNameInTheCart(), "Kapar�s Kincskeres� T�rk�p Gyerekeknek");
        Assert.assertEquals(cartPage.getSecondProductNameInTheCart(), "Kapar�s Adventi Napt�r Gyerekeknek");
        //10.Step: Checking the price.
        Assert.assertEquals(cartPage.getPriceAmount(), "R�sz�sszeg 10.480 Ft");
    }
}
