package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By lastNameInputBy = By.id("billing_last_name");
    private final By firstNameInputBy = By.id("billing_first_name");
    private final By taxNumberInputBy = By.id("wc_szamlazz_adoszam");
    private final By postalCodeInputBy = By.id("billing_postcode");
    private final By streetAndHouseNumberInputBy = By.id("billing_address_1");
    private final By floorAndApartmentInputBy = By.id("billing_address_2");
    private final By phoneNumberInputBy = By.id("billing_phone");
    private final By emailAddressInputBy = By.id("billing_email");
    private final By homeDeliveryFAMACourierServiceRadioButtonBy = By.id("shipping_method_0_flat_rate6");
    private final By foxpostParcelMachineRadioButtonBy = By.id("shipping_method_0_vp_pont8");
    private final By homeDeliveryWithCashOnDeliveryFAMACourierServiceBy = By.id("shipping_method_0_flat_rate4");
    private final By barionCardPaymentRadioButtonBy = By.cssSelector("label[for='payment_method_barion']");
    private final By generalTermsAndConditionsFieldBy = By.id("terms");
    private final By payWithBarionButtonBy = By.id("place_order");
    private final By shipToAnotherAddressFieldBy = By.id("ship-to-different-address-checkbox");
    private final By lastNameInputFieldAtAnotherDeliveryAddressBy = By.id("shipping_last_name");
    private final By firstNameInputFieldAtAnotherDeliveryAddressBy = By.id("shipping_first_name");
    private final By postalCodeInputFieldAtAnotherDeliveryAddressBy = By.id("shipping_postcode");
    private final By streetAndHouseNumberInputFieldAtAnotherDeliveryAddressBy = By.id("shipping_address_1");
    private final By otherAddressDataInputFieldAtAnotherDeliveryAddressBy = By.id("shipping_address_2");
    private final By orderNotesInputFieldAtAnotherDeliveryAddressBy = By.id("order_comments");
    private final By lastNameBy = By.id("billing_last_name");
    private final By firstNameBy = By.id("billing_first_name");
    private final By postalCodeBy = By.id("billing_postcode");
    private final By streetAndHouseNumberBy = By.id("billing_address_1");
    private final By phoneNumberBy = By.id("billing_phone");
    private final By emailAddressBy = By.id("billing_email");
    private final By lastNameAtAnotherDeliveryAddressBy = By.id("shipping_last_name");
    private final By firstNameAtAnotherDeliveryAddressBy = By.id("shipping_first_name");
    private final By postalCodeAtAnotherDeliveryAddressBy = By.id("shipping_postcode");
    private final By streetAndHouseNumberAtAnotherDeliveryAddressBy = By.id("shipping_address_1");
    private final By otherAddressDataAtAnotherDeliveryAddressBy = By.id("shipping_address_2");
    private final By taxNumberBy = By.id("wc_szamlazz_adoszam");
    private final By floorAndApartmentBy = By.id("billing_address_2");
    private final By priceAmountBy = By.className("order-total");
    private final By freeShippingTextBy = By.id("shipping_method");
    private final By shippingAmountBy = By.className("vp-woo-pont-shipping-method-label");
    private final By popupMapWindowBy = By.cssSelector("a[href='#");
    private final By popupWindowBy = By.className("om-popup-close-x");

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public void fillLastNameInputField(String lastName){
        System.out.println("We fill the last name input field on the " + className + ".");
        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys(lastName);
    }

    public void fillFirstNameInputField(String firstName){
        System.out.println("We fill the first name input field on the " + className + ".");
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys(firstName);
    }

    public void fillTaxNumberInputField(String taxNumber){
        System.out.println("We fill the tax number input field on the " + className + ".");
        WebElement taxNumberInput = driver.findElement(taxNumberInputBy);
        taxNumberInput.sendKeys(taxNumber);
    }

    public void fillPostalCodeInputField(String postalCode){
        System.out.println("We fill the postal code input field on the " + className + ".");
        WebElement postalCodeInput = driver.findElement(postalCodeInputBy);
        postalCodeInput.sendKeys(postalCode);
    }

    public void fillStreetAndHouseNumberInputField(String streetAndHouseNumber){
        System.out.println("We fill the street and house number input field on the " + className + ".");
        WebElement streetInput = driver.findElement(streetAndHouseNumberInputBy);
        streetInput.sendKeys(streetAndHouseNumber);
    }

    public void fillFloorAndApartmentInputField(String floorAndApartment){
        System.out.println("We fill floor and apartment input field on the " + className + ".");
        WebElement floorAndApartmentInput= driver.findElement(floorAndApartmentInputBy);
        floorAndApartmentInput.sendKeys(floorAndApartment);
    }

    public void fillPhoneNumberInputField(String phoneNumber){
        System.out.println("We fill the phone number input field on the " + className + ".");
        WebElement streetInput = driver.findElement(phoneNumberInputBy);
        streetInput.sendKeys(phoneNumber);
    }

    public void fillEmailAddressInputField(String emailAddress) {
        System.out.println("We fill e-mail address input field on the " + className + ".");
        WebElement emailAddressInput = driver.findElement(emailAddressInputBy);
        emailAddressInput.sendKeys(emailAddress);
    }

    public void clickHomeDeliveryWithCashOnDeliveryFAMACourierService() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeDeliveryWithCashOnDeliveryFAMACourierServiceBy));
        wait.until(ExpectedConditions.elementToBeClickable(homeDeliveryWithCashOnDeliveryFAMACourierServiceBy));
        System.out.println(className + ": We choose home delivery with cash on delivery (FÁMA courier service) delivery and payment option.");
        WebElement homeDeliveryWithCashOnDeliveryFAMACourierService = driver.findElement(homeDeliveryWithCashOnDeliveryFAMACourierServiceBy);
        homeDeliveryWithCashOnDeliveryFAMACourierService.click();
    }

    public void clickHomeDeliveryFAMACourierServiceRadioButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeDeliveryFAMACourierServiceRadioButtonBy));
        wait.until(ExpectedConditions.elementToBeClickable(homeDeliveryFAMACourierServiceRadioButtonBy));
        System.out.println(className + ": We choose home delivery with FÁMA courier service.");
        WebElement homeDeliveryFAMACourierServiceRadioButton = driver.findElement(homeDeliveryFAMACourierServiceRadioButtonBy);
        homeDeliveryFAMACourierServiceRadioButton.click();
        //Thread.sleep(3000);
    }

    public void clickFoxpostParcelMachineRadioButton() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,420)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(foxpostParcelMachineRadioButtonBy));
        wait.until(ExpectedConditions.elementToBeClickable(foxpostParcelMachineRadioButtonBy));
        System.out.println(className + ": We choose Foxpost parcel machine option.");
        WebElement foxpostParcelMachineRadioButton = driver.findElement(foxpostParcelMachineRadioButtonBy);
        foxpostParcelMachineRadioButton.click();
    }

    public void clickBarionCardPaymentRadioButton() throws InterruptedException {
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,400)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(barionCardPaymentRadioButtonBy));
        wait.until(ExpectedConditions.elementToBeClickable(barionCardPaymentRadioButtonBy));
        System.out.println(className + ": We choose Barion - card payment.");
        WebElement barionCardPaymentRadioButton = driver.findElement(barionCardPaymentRadioButtonBy);
        barionCardPaymentRadioButton.click();
        Thread.sleep(3000);
    }

    public void clickGeneralTermsAndConditionsField(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(generalTermsAndConditionsFieldBy));
        wait.until(ExpectedConditions.elementToBeClickable(generalTermsAndConditionsFieldBy));
        System.out.println(className + ": We accept general terms and conditions.");
        WebElement generalTermsAndConditionsField = driver.findElement(generalTermsAndConditionsFieldBy);
        generalTermsAndConditionsField.click();
    }

    public void clickPayWithBarionButton() {
        System.out.println(className + ": We complete the order and navigate to the payment page.");
        WebElement payWithBarionButton = driver.findElement(payWithBarionButtonBy);
        payWithBarionButton.click();
    }

    public void clickShipToAnotherAddressField(){
        System.out.println(className + ": We choose 'Ship to another address' option.");
        WebElement shipToAnotherAddressField = driver.findElement(shipToAnotherAddressFieldBy);
        shipToAnotherAddressField.click();
    }

    public void fillLastNameInputFieldAtAnotherDeliveryAddress(String lastNameAtAnotherDeliveryAddress){
        System.out.println("We fill the last name input field at the another delivery address" + className + ".");
        WebElement lastNameInputFieldAtAnotherDeliveryAddress = driver.findElement(lastNameInputFieldAtAnotherDeliveryAddressBy);
        lastNameInputFieldAtAnotherDeliveryAddress.sendKeys(lastNameAtAnotherDeliveryAddress);
    }

    public void fillFirstNameInputFieldAtAnotherDeliveryAddress(String firstNameAtAnotherDeliveryAddress){
        System.out.println("We fill the first name input field at the another delivery address" + className + ".");
        WebElement firstNameInputFieldAtAnotherDeliveryAddress = driver.findElement(firstNameInputFieldAtAnotherDeliveryAddressBy);
        firstNameInputFieldAtAnotherDeliveryAddress.sendKeys(firstNameAtAnotherDeliveryAddress);
    }

    public void fillPostalCodeInputFieldAtAnotherDeliveryAddress(String postalCodeAtAnotherDeliveryAddress){
        System.out.println("We fill the postal code input field at the another delivery address" + className + ".");
        WebElement postalCodeInputFieldAtAnotherDeliveryAddress = driver.findElement(postalCodeInputFieldAtAnotherDeliveryAddressBy);
        postalCodeInputFieldAtAnotherDeliveryAddress.sendKeys(postalCodeAtAnotherDeliveryAddress);
    }

    public void fillStreetAndHouseNumberInputFieldAtAnotherDeliveryAddress(String streetAndHouseNumberAtAnotherDeliveryAddress){
        System.out.println("We fill the street and house number input field at the another delivery address" + className + ".");
        WebElement streetAndHouseNumberInputFieldAtAnotherDeliveryAddress = driver.findElement(streetAndHouseNumberInputFieldAtAnotherDeliveryAddressBy);
        streetAndHouseNumberInputFieldAtAnotherDeliveryAddress.sendKeys(streetAndHouseNumberAtAnotherDeliveryAddress);
    }

    public void fillOtherAddressDataInputFieldAtAnotherDeliveryAddress(String otherAddressDataAtAnotherDeliveryAddress){
        System.out.println("We fill the other address data input field at the another delivery address" + className + ".");
        WebElement otherAddressDataInputFieldAtAnotherDeliveryAddress = driver.findElement(otherAddressDataInputFieldAtAnotherDeliveryAddressBy);
        otherAddressDataInputFieldAtAnotherDeliveryAddress.sendKeys(otherAddressDataAtAnotherDeliveryAddress);
    }

    public void fillOrderNotesInputFieldAtAnotherDeliveryAddress(String orderNotesAtAnotherDeliveryAddress){
        System.out.println("We fill the order notes input field at the another delivery address" + className + ".");
        WebElement orderNotesInputFieldAtAnotherDeliveryAddress = driver.findElement(orderNotesInputFieldAtAnotherDeliveryAddressBy);
        orderNotesInputFieldAtAnotherDeliveryAddress.sendKeys(orderNotesAtAnotherDeliveryAddress);
    }

    public String getLastName(){
        System.out.println(className + ": Checking the last name.");
        WebElement lastName = driver.findElement(lastNameBy);
        return lastName.getAttribute("value");
    }

    public String getFirstName(){
        System.out.println(className + ": Checking the first name.");
        WebElement firstName = driver.findElement(firstNameBy);
        return firstName.getAttribute("value");
    }

    public String getTaxNumber(){
        System.out.println(className + ": Checking the tax number.");
        WebElement taxNumber = driver.findElement(taxNumberBy);
        return taxNumber.getAttribute("value");
    }

    public String getPostalCode(){
        System.out.println(className + ": Checking the postal code.");
        WebElement postalCode = driver.findElement(postalCodeBy);
        return postalCode.getAttribute("value");
    }

    public String getStreetAndHouseNumber(){
        System.out.println(className + ": Checking the street and the house number.");
        WebElement streetAndHouseNumber = driver.findElement(streetAndHouseNumberBy);
        return streetAndHouseNumber.getAttribute("value");
    }

    public String getFloorAndApartment(){
        System.out.println(className + ": Checking the floor and the apartment.");
        WebElement floorAndApartment = driver.findElement(floorAndApartmentBy);
        return floorAndApartment.getAttribute("value");
    }

    public String getPhoneNumber(){
        System.out.println(className + ": Checking the phone number.");
        WebElement phoneNumber = driver.findElement(phoneNumberBy);
        return phoneNumber.getAttribute("value");
    }

    public String getEmailAddress(){
        System.out.println(className + ": Checking the email address.");
        WebElement emailAddress = driver.findElement(emailAddressBy);
        return emailAddress.getAttribute("value");
    }

    public String getLastNameAtAnotherDeliveryAddress(){
        System.out.println(className + ": Checking the last name at another delivery address.");
        WebElement lastNameAtAnotherDeliveryAddress = driver.findElement(lastNameAtAnotherDeliveryAddressBy);
        return lastNameAtAnotherDeliveryAddress.getAttribute("value");
    }

    public String getFirstNameAtAnotherDeliveryAddress(){
        System.out.println(className + ": Checking the first name at another delivery address.");
        WebElement firstNameAtAnotherDeliveryAddress = driver.findElement(firstNameAtAnotherDeliveryAddressBy);
        return firstNameAtAnotherDeliveryAddress.getAttribute("value");
    }

    public String getPostalCodeAtAnotherDeliveryAddress(){
        System.out.println(className + ": Checking the postal code at another delivery address.");
        WebElement postalCodeAtAnotherDeliveryAddress = driver.findElement(postalCodeAtAnotherDeliveryAddressBy);
        return postalCodeAtAnotherDeliveryAddress.getAttribute("value");
    }

    public String getStreetAndHouseNumberAtAnotherDeliveryAddress(){
        System.out.println(className + ": Checking the street and house number at another delivery address.");
        WebElement streetAndHouseNumberAtAnotherDeliveryAddress = driver.findElement(streetAndHouseNumberAtAnotherDeliveryAddressBy);
        return streetAndHouseNumberAtAnotherDeliveryAddress.getAttribute("value");
    }

    public String getOtherAddressDataAtAnotherDeliveryAddress(){
        System.out.println(className + ": Checking the other address data at another delivery address.");
        WebElement otherAddressDataAtAnotherDeliveryAddress = driver.findElement(otherAddressDataAtAnotherDeliveryAddressBy);
        return otherAddressDataAtAnotherDeliveryAddress.getAttribute("value");
    }

    public String getPriceAmount() {
        System.out.println(className + ": Checking the total amount.");
        WebElement priceAmount = driver.findElement(priceAmountBy);
        return priceAmount.getText();
    }

    public String getFreeShippingText() {
        System.out.println(className + ": Checking the shipping is free.");
        WebElement freeShippingText = driver.findElement(freeShippingTextBy);
        return freeShippingText.getText();
    }

    public void closePopupMapWindow() {
        System.out.println(className + ": We close the pop-up map window.");
        WebElement popupMapWindow = driver.findElement(popupMapWindowBy);
        popupMapWindow.click();
    }

    public String getShippingAmount() {
        System.out.println(className + ": Checking the shipping amount.");
        WebElement shippingAmount = driver.findElement(shippingAmountBy);
        return shippingAmount.getText();
    }

    public void closePopupWindow() {
        System.out.println(className + ": We close the pop-up window.");
        WebElement popupWindow = driver.findElement(popupWindowBy);
        popupWindow.click();
    }
}
