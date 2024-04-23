package survivals.shippingAndPaymentTests;

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

public class ShippingAndPaymentTest1 extends DriverFactory {
    @Test(priority = 1)
    @Description("KH-T12 Purchase with home delivery, cash on delivery payment in an amount not exceeding 15,000 HUF")
    public void buyingWithHomeDeliveryAndCashOnDeliveryPaymentMethodNotGreaterThan15000HUF() throws InterruptedException {
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
        //3.Step: Put the product into the cart.
        Product3Page product3Page = new Product3Page(driver, wait);
        product3Page.clickPutInTheCartButton();
        //4.Step: Navigate to the checkout from the popup window.
        product3Page.clickCheckoutButton();
        //5.Step: Choose home delivery with cash on delivery (F�MA courier service) delivery and payment option.
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.clickHomeDeliveryWithCashOnDeliveryFAMACourierService();
        //Checking
        //6.Step: Check the total amount.
        Assert.assertEquals(checkoutPage.getPriceAmount(), "�sszeg 6.290 Ft");
    }
}