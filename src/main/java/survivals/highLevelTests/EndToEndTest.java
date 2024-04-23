package survivals.highLevelTests;

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

public class EndToEndTest extends DriverFactory {
    @Test(priority = 1)
    @Description("KH-T33 Tracking the purchase process from the start page to the order of the selected product (EndToEnd_Test)")
    public void purchaseProcessFromHomePageToPaymentPage () throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to contact page.
        homePage.clickContact();
        //2.Step: Navigate from contact page back to home page with logo in header.
        ContactPage contactPage = new ContactPage(driver);
        contactPage.clickLogoAndBackToHomePage();
        //3.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //4.Step: Select product and navigate to the product page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct3Name();
        //5.Step: Put the product into the cart.
        Product3Page product3Page = new Product3Page(driver, wait);
        product3Page.clickPutInTheCartButton();
        //6.Step: Navigate to the cart from the popup window.
        product3Page.clickCartButton();
        //7.Step: Increase the quantity of the product by 1 with the '+' button and wait for the application to update automatically.
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickPlusButtonAndIncreaseQuantity();
        //8.Step: Navigate from cart page to the checkout page.
        cartPage.clickGoToCheckoutButton();
        //9.Step: Fill last name input field.
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.fillLastNameInputField("Mekk");
        //10.Step: Fill first name input field.
        checkoutPage.fillFirstNameInputField("Elek");
        //11.Step: Fill postal code input field and wait for the application to fill city input field automatically.
        checkoutPage.fillPostalCodeInputField("1034");
        //12.Step: Fill street input field.
        checkoutPage.fillStreetAndHouseNumberInputField("Kecske utca, 1.");
        //13.Step: Fill phone number input field.
        checkoutPage.fillPhoneNumberInputField("06203334455");
        //14.Step: Fill email address input field.
        checkoutPage.fillEmailAddressInputField("mekkelek@gmail.com");
        Thread.sleep(5000);
        //15.Step: Choose home delivery with FÁMA courier service.
        checkoutPage.clickHomeDeliveryFAMACourierServiceRadioButton();
        //16.Step: Choose 'Barion-cardpayment' option.
        checkoutPage.clickBarionCardPaymentRadioButton();
        //17.Step: Accept general terms and conditions.
        checkoutPage.clickGeneralTermsAndConditionsField();
        //18.Step: Completing the order and navigate to the payment page.
        checkoutPage.clickPayWithBarionButton();
        //Checking
        PaymentPage paymentPage = new PaymentPage(driver);
        //19.Step: Check whether the payment page loads.
        Assert.assertTrue(paymentPage.getPaymentServiceLogo());
    }
}