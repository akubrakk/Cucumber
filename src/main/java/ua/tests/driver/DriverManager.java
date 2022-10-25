package ua.tests.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

public class DriverManager {


    private static final long IMPLICIT_WAIT_TIMEOUT = 10;
    private static final long PAGE_lOAD_TIMEOUT = 10;

    public static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }
    public static void setupDriver(){
        WebDriver driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_lOAD_TIMEOUT));
        webDriverThreadLocal.set(driver);
    }
    public static WebDriver getDriver(){
       return webDriverThreadLocal.get();
    }

    public static void quitDriver(){
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();

        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }

    private static WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
