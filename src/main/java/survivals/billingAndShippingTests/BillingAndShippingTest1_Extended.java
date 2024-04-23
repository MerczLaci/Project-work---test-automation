package survivals.billingAndShippingTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import survivals.pages.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
 */

public class BillingAndShippingTest1_Extended extends DriverFactory {
    static Logger log = Logger.getLogger(BillingAndShippingTest1_Extended.class);

    @DataProvider(name = "customers-data-provider")
    public Object[][]customersDataProvider() {
        List<String> customerTextData = readFromFile("files/customers_data.txt");
        String[] details = analyseCustomerDataList(customerTextData);
        Object[][] customersData = {details};
        return customersData;
    }

    public static List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("The customers data:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (
                IOException e) {
            System.out.println("The file does not exist!" + e.getMessage());
        }
        return lines;
    }

    public static String[] analyseCustomerDataList(List<String> list) {
        String[] details = new String[list.size()];
        int i = 0;
        for (String customerTextData : list) {
            String[] customerData = customerTextData.split(": ");
            String actualData = customerData[1];
            details[i] = actualData;
            i++;
            System.out.println("data: " + actualData);
        }
        return details;
    }

    @Test(priority = 1, dataProvider = "customers-data-provider")
    @Description("KH-T28 Fill mandatory and optional fields of billing data then we choose another delivery address and fill mandatory and optional fields, costumers data come from text file, create log file")
    public void fillBillingDataMandatoryAndOptionalFieldsAndAnotherDeliveryAddressMandatoryAndOptionalFields (String lastName, String firstName, String taxNumber, String postalCode, String streetAndHouseNumber, String floorAndApartment, String phoneNumber, String emailAddress, String lastName2, String firstName2, String postalCode2, String streetAndHouseNumber2, String otherAddress, String orderNotes) throws InterruptedException {
        log.debug("fillBillingDataMandatoryAndOptionalFieldsAndAnotherDeliveryAddressMandatoryAndOptionalFields method reached");
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
        //4.Step: Navigate to the cart from the popup window.
        product3Page.clickCartButton();
        //5.Step: Navigate from cart page to the checkout page.
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickGoToCheckoutButton();
        //6.Step: Fill last name input field.
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.fillLastNameInputField(lastName);
        //7.Step: Fill first name input field.
        checkoutPage.fillFirstNameInputField(firstName);
        //8.Step: Fill first tax number input field.
        checkoutPage.fillTaxNumberInputField(taxNumber);
        //9.Step: Fill postal code input field and wait for the application to fill city input field automatically.
        checkoutPage.fillPostalCodeInputField(postalCode);
        //10.Step: Fill street input field.
        checkoutPage.fillStreetAndHouseNumberInputField(streetAndHouseNumber);
        //11.Step: Fill floor and apartment input field.
        checkoutPage.fillFloorAndApartmentInputField(floorAndApartment);
        //12.Step: Fill phone number input field.
        checkoutPage.fillPhoneNumberInputField(phoneNumber);
        //13.Step: Fill email address input field.
        checkoutPage.fillEmailAddressInputField(emailAddress);
        Thread.sleep(5000);
        checkoutPage.closePopupWindow();
        //14.Step: Choose home delivery with F?MA courier service.
        checkoutPage.clickHomeDeliveryFAMACourierServiceRadioButton();
        //15.Step: Choose 'Barion-card payment' option.
        checkoutPage.clickBarionCardPaymentRadioButton();
        //16.Step: On the 'Checkout' page choose check box: 'Ship to another address?' option.
        checkoutPage.clickShipToAnotherAddressField();
        //17.Step: Fill last name input field under the delivery to another address option.
        checkoutPage.fillLastNameInputFieldAtAnotherDeliveryAddress(lastName2);
        //18.Step: Fill first name input field under the delivery to another address option.
        checkoutPage.fillFirstNameInputFieldAtAnotherDeliveryAddress(firstName2);
        //19.Step: Fill postal code input field under the delivery to another address option.
        checkoutPage.fillPostalCodeInputFieldAtAnotherDeliveryAddress(postalCode2);
        //20.Step: Fill street input field under the delivery to another address option.
        checkoutPage.fillStreetAndHouseNumberInputFieldAtAnotherDeliveryAddress(streetAndHouseNumber2);
        //21.Step: Fill other address data input field under the delivery to another address option.
        checkoutPage.fillOtherAddressDataInputFieldAtAnotherDeliveryAddress(otherAddress);
        //22.Step: Fill order notes input field under the delivery to another address option.
        checkoutPage.fillOrderNotesInputFieldAtAnotherDeliveryAddress(orderNotes);
        //Checking
        //23.Step: Check whether all the entered data is still filled with the previously recorded data.
        Assert.assertEquals(checkoutPage.getLastName(), lastName);
        Assert.assertEquals(checkoutPage.getFirstName(), firstName);
        Assert.assertEquals(checkoutPage.getTaxNumber(), taxNumber);
        Assert.assertEquals(checkoutPage.getPostalCode(), postalCode);
        Assert.assertEquals(checkoutPage.getStreetAndHouseNumber(), streetAndHouseNumber);
        Assert.assertEquals(checkoutPage.getFloorAndApartment(), floorAndApartment);
        Assert.assertEquals(checkoutPage.getPhoneNumber(), phoneNumber);
        Assert.assertEquals(checkoutPage.getEmailAddress(), emailAddress);
        Assert.assertEquals(checkoutPage.getLastNameAtAnotherDeliveryAddress(), lastName2);
        Assert.assertEquals(checkoutPage.getFirstNameAtAnotherDeliveryAddress(), firstName2);
        Assert.assertEquals(checkoutPage.getPostalCodeAtAnotherDeliveryAddress(), postalCode2);
        Assert.assertEquals(checkoutPage.getStreetAndHouseNumberAtAnotherDeliveryAddress(), streetAndHouseNumber2);
        Assert.assertEquals(checkoutPage.getOtherAddressDataAtAnotherDeliveryAddress(), otherAddress);
    }
}