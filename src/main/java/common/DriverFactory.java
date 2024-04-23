package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void webDriverSetup() {
        /** ----  konfigurálás eleje ---- **/
        String userDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", userDirectory + "\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000)); //maximum a megadott mp.-ig várakozik az oldal betöltésére
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); //maximum megadott mp.-ig várakozik, hogy az elemek megjelenjenek
        driver.manage().window().maximize();       //teljes képernyőre nagyítás

        //Explicit wait beállítás
        wait = new WebDriverWait(driver, Duration.ofMillis(30000)); //30mp
        /** ----  konfigurálás vége ---- **/
    }

    @AfterSuite
    public void webDriverTearDown() throws InterruptedException {
        Thread.sleep(3000);   //meg tudjuk állítani a program futását 3mp-ig
        driver.quit();
    }
}
