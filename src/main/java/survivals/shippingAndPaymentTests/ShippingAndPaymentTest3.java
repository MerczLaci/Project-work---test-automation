package survivals.shippingAndPaymentTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.*;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
 */

public class ShippingAndPaymentTest3 extends DriverFactory {
    @Test(priority = 1)
    @Description("KH-T19 Purchase with delivery to a Foxpost parcel machine, cash on delivery payment in an amount not exceeding 15,000 HUF")
    public void buyingDeliveryToParcelMachineAndCashOnDeliveryPaymentMethodNotGreaterThan15000HUF() throws InterruptedException {
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
        //5.Step: Choose 'Parcel Point / Parcel Vending Machine' delivery option
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.clickFoxpostParcelMachineRadioButton();
        //6.Step: Close the pop-up map window
        checkoutPage.closePopupMapWindow();
        driver.get("https://kaparoskalandok.hu/penztar/");
        //Checking
        //7.Step: Check the shipping amount.
        Assert.assertEquals(checkoutPage.getShippingAmount(), "Csomagpont / Csomagautomata: 1.290 Ft");
        //8.Step: Check the total amount.
        Assert.assertEquals(checkoutPage.getPriceAmount(), "Összeg 4.490 Ft");
    }
}