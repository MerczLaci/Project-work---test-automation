package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final By paymentServiceLogoBy = By.className("barion-logo");
    public PaymentPage(WebDriver driver) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
    }

    public Boolean getPaymentServiceLogo() {
        System.out.println(className + ": We check whether the payment page loads.");
        WebElement paymentServiceLogo = driver.findElement(paymentServiceLogoBy);
        return paymentServiceLogo.isDisplayed();
    }
}
