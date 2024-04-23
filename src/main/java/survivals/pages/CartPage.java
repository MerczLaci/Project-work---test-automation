package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    private final String className = getClass().getName();
    private WebDriver driver;
    private WebDriverWait wait;
    private final By productTitleBy = By.className("no-lightbox");
    private final By priceAmountBy = By.className("cart-subtotal");
    private final By plusButtonBy = By.className("plus");
    private final By goToCheckoutButtonBy = By.className("checkout-button");
    private final By xDeleteButtonBy = By.className("remove");
    private final By cartEmptyTextBy = By.className("is-info");
    private final By updatedQuantityBy = By.className("input-text");
    private final By updatedAmountBy = By.className("cart-subtotal");
    private final By productsBy = By.className("menu-item-3360");
    private final By productNameBy = By.className("product-name");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public Boolean getProductTitle() {
        System.out.println(className + ": Checking the cart with the product.");
        WebElement productTitle = driver.findElement(productTitleBy);
        return productTitle.isDisplayed();
    }

    public String getPriceAmount() {
        System.out.println(className + ": Checking the price.");
        WebElement priceAmount = driver.findElement(priceAmountBy);
        return priceAmount.getText();
    }

    public void clickPlusButtonAndIncreaseQuantity() throws InterruptedException {
        System.out.println(className + ": We increase the quantity of the product by 1 with the '+' button and wait for the application to update automatically.");
        WebElement plusButton = driver.findElement(plusButtonBy);
        plusButton.click();
        Thread.sleep(3000);
    }

    public void clickGoToCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCheckoutButtonBy));
        wait.until(ExpectedConditions.elementToBeClickable(goToCheckoutButtonBy));
        System.out.println(className + ": We navigate from the cart page to the checkout page.");
        WebElement goToCheckoutButton = driver.findElement(goToCheckoutButtonBy);
        goToCheckoutButton.click();
    }

    public String getUpdatedQuantity() {
        System.out.println(className + ": Checking the quantity.");
        WebElement updatedQuantity = driver.findElement(updatedQuantityBy);
        return updatedQuantity.getAttribute("value");
    }

    public String getUpdatedAmount() {
        System.out.println(className + ": Checking the updated amount.");
        WebElement updatedAmount = driver.findElement(updatedAmountBy);
        return updatedAmount.getText();
    }

    public void clickXDeleteButton() throws InterruptedException {
        System.out.println(className + ": We delete the product from the cart.");
        WebElement xDeleteButton = driver.findElement(xDeleteButtonBy);
        xDeleteButton.click();
        Thread.sleep(3000);
    }

    public String getCartEmptyText() {
        System.out.println(className + ": Checking the cart is empty.");
        WebElement cartEmptyText = driver.findElement(cartEmptyTextBy);
        return cartEmptyText.getText();
    }

    public void clickProducts() throws InterruptedException {
        System.out.println(className + ": We click on the 'products menu point'.");
        WebElement products = driver.findElement(productsBy);
        products.click();
        products.click();
    }

    public String getFirstProductNameInTheCart() {
        System.out.println(className + ": We check the name of the first product.");
        List<WebElement> productNames = driver.findElements(productNameBy);
        WebElement productName = productNames.get(3);
        return productName.getText();
    }

    public String getSecondProductNameInTheCart() {
        System.out.println(className + ": We check the name of the second product.");
        List<WebElement> productNames = driver.findElements(productNameBy);
        WebElement productName = productNames.get(4);
        return productName.getText();
    }
}
