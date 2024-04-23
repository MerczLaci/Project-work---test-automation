package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By acceptAllButtonBy = By.className("cky-btn-accept");
    private final By headerBoxBy = By.className("elementor-heading-title");
    private final By productsBy = By.className("menu-item-3360");
    private final By blogBy = By.className("menu-item-138");
    private final By faqBy = By.className("menu-item-391");
    private final By contactBy = By.className("menu-item-136");
    private final By termsOfPurchaseBy = By.cssSelector("a[href='https://kaparoskalandok.hu/vasarlasi-feltetelek/");
    private final By privacyPolicyBy = By.cssSelector("a[href='https://kaparoskalandok.hu/adatvedelmi-szabalyzat/");
    private final By generalTermsAndConditionsBy = By.cssSelector("a[href='https://kaparoskalandok.hu/altalanos-szerzodesi-feltetelek/");
    private final By welcomeTextBy = By.className("elementor-heading-title");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAcceptAllButton() throws InterruptedException {
        //action is required to appear acceptAllButton
        System.out.println(className + ": We click on the 'accept all' button.");
        WebElement headerBox = driver.findElement(headerBoxBy);
        headerBox.click();

        wait.until(ExpectedConditions.elementToBeClickable(acceptAllButtonBy));
        WebElement acceptAllButton = driver.findElement(acceptAllButtonBy);
        acceptAllButton.click();
        Thread.sleep(1000);
    }

    public void clickProducts() throws InterruptedException {
        System.out.println(className + ": We click on the 'products menu point'.");
        WebElement products = driver.findElement(productsBy);
        products.click();
        products.click();
    }

    public void clickBlog() {
        System.out.println(className + ": We click on the 'blog menu point'.");
        WebElement blog = driver.findElement(blogBy);
        blog.click();
    }

    public void clickFAQ() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(faqBy));
        System.out.println(className + ": We click on the 'FAQ' menu point.");
        WebElement faq = driver.findElement(faqBy);
        faq.click();
        Thread.sleep(1000);
    }

    public void clickContact() {
        System.out.println(className + ": We click on the 'contact' menu point.");
        WebElement contact = driver.findElement(contactBy);
        contact.click();
    }

    public void clickTermsOfPurchase() {
        System.out.println(className + ": We click on the terms of purchase in the footer.");
        WebElement termsOfPurchase = driver.findElement(termsOfPurchaseBy);
        termsOfPurchase.click();
    }

    public void clickPrivacyPolicy() {
        System.out.println(className + ": We click on the privacy policy in the footer.");
        WebElement privacyPolicy = driver.findElement(privacyPolicyBy);
        privacyPolicy.click();
    }

    public void clickGeneralTermsAndConditions() {
        System.out.println(className + ": We click on the general terms and conditions in the footer.");
        WebElement generalTermsAndConditions = driver.findElement(generalTermsAndConditionsBy);
        generalTermsAndConditions.click();
    }

    public String getWelcomeText() {
        System.out.println(className + ": Checking that home page loaded.");
        List<WebElement> texts = driver.findElements(welcomeTextBy);
        WebElement welcomeText = texts.get(2);
        return welcomeText.getText();
    }
}
