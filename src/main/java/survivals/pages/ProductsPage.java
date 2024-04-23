package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/*
Comment about products:
Product1-Páros Élmények-Kaparós Ajándék Pároknak
Product2-Kaparós Kincskeresõ Térkép Gyerekeknek
Product3-Kaparós Adventi Naptár Gyerekeknek
 */

public class ProductsPage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final By logoButtonBy = By.className("elementor-element-f17a051");
    private final By product2NameBy = By.className("product_title");
    private final By product3NameBy = By.className("product_title");
    private final By product2ImageBy = By.className("wp-image-3364");


    public ProductsPage(WebDriver driver) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
    }

    public void clickLogoAndBackToHomePage() throws InterruptedException {
        System.out.println(className + ": We click on the 'logo' button in the header.");
        WebElement logoButton = driver.findElement(logoButtonBy);
        logoButton.click();
        Thread.sleep(1000);
    }

    public void clickProduct2Name() {
        System.out.println(className + ": We click on the name of the Product2.");
        List<WebElement> productNames1 = driver.findElements(product2NameBy);
        WebElement product2Name = productNames1.get(3);
        product2Name.click();
    }

    public void clickProduct3Name() {
        System.out.println(className + ": We click on the name of the Product3.");
        List<WebElement> productNames2 = driver.findElements(product3NameBy);
        WebElement product3Name = productNames2.get(6);
        product3Name.click();
    }

    public void clickProduct2Image() {
        System.out.println(className + ": We click on the image of the Product2.");
        WebElement product2Image = driver.findElement(product2ImageBy);
        product2Image.click();
    }
}
