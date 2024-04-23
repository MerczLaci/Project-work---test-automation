package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FAQPage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By logoButtonBy = By.className("elementor-element-7584760");
    private final By logoInTheFooterBy = By.className("elementor-element-e8f151f");

    public FAQPage(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLogoAndBackToHomePage() throws InterruptedException {
        System.out.println(className + ": We click on the logo.");
        WebElement logoButton = driver.findElement(logoButtonBy);
        logoButton.click();
        Thread.sleep(1000);
    }

    public void clickLogoInTheFooterAndBackToHomePage() throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.elementToBeClickable(logoInTheFooterBy));
        System.out.println(className + ": We click on the logo in the footer.");
        WebElement logoInTheFooter = driver.findElement(logoInTheFooterBy);
        logoInTheFooter.click();
        logoInTheFooter.click();
        Thread.sleep(1000);
    }
}
