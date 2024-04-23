package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
 */

public class Product2Page {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By putInTheCartButtonBy = By.className("single_add_to_cart_button");
    private final By cartButtonBy = By.className("elementor-button");
    private final By product2NameBy = By.className("elementor-widget-container");

    public Product2Page(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public void clickPutInTheCartButton() throws InterruptedException {
        System.out.println(className + ": We click on the 'put in the cart' button.");
        WebElement putInTheCartButton = driver.findElement(putInTheCartButtonBy);
        putInTheCartButton.click();
        Thread.sleep(11000);
    }

    public void clickCartButton() throws InterruptedException {
        System.out.println(className + ": We click on the 'cart' button.");
        List<WebElement> popupElements = driver.findElements(cartButtonBy);
        WebElement cartButton = popupElements.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(cartButtonBy));
        cartButton.click();
    }

    public String getProduct2Name() {
        System.out.println(className + ": Checking that product2's page loaded.");
        List<WebElement> texts = driver.findElements(product2NameBy);
        WebElement product2Name = texts.get(5);
        return product2Name.getText();
    }
}
