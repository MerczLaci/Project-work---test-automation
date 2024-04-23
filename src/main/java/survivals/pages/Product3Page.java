package survivals.pages;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
*/

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Product3Page {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By putInTheCartButtonBy = By.className("single_add_to_cart_button");
    private final By cartButtonBy = By.className("elementor-button");
    private final By checkoutButtonBy = By.className("elementor-button");
    private final By quantityInputBy = By.id("quantity_660755b365f0c");

    public Product3Page(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public void clickPutInTheCartButton() throws InterruptedException {
        System.out.println(className + ": We click on the 'put in the cart' button.");
        WebElement putInTheCartButton = driver.findElement(putInTheCartButtonBy);
        putInTheCartButton.click();
        Thread.sleep(15000);
    }

    public void clickCartButton() throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,420)");
        System.out.println(className + ": We click on the 'cart' button.");
        List<WebElement> popupElements = driver.findElements(cartButtonBy);
        WebElement cartButton = popupElements.get(0);
        cartButton.click();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButtonBy));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonBy));
        System.out.println(className + ": We click on the 'checkout' button.");
        List<WebElement> popupElements = driver.findElements(checkoutButtonBy);
        WebElement checkoutButton = popupElements.get(1);
        checkoutButton.click();
    }

    public void fillInTheQuantityInputField(String quantity) {
        System.out.println("We fill in the quantity input field on the " + className + ".");
        WebElement quantityInput = driver.findElement(quantityInputBy);
        quantityInput.sendKeys(quantity);
    }

    public void clearTheQuantityInputField() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,420)");
        System.out.println("We clear the quantity input field on the " + className + ".");
        WebElement quantityInput = driver.findElement(quantityInputBy);
        quantityInput.clear();
    }
}
