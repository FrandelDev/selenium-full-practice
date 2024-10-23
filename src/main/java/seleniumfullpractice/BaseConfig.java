package seleniumfullpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConfig {

    private static WebDriver driver;
    private WebDriverWait driverWait;
    private static BaseConfig baseConfigInstance;

    private BaseConfig(){
        driver = new ChromeDriver();
    }
    public static BaseConfig getInstance(){
        if(baseConfigInstance == null){
            baseConfigInstance = new BaseConfig();
        }
        return baseConfigInstance;
    }

   public static WebDriver getDriverInstance(){
        return driver;
   }

    public WebDriver initialize(){
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        return getDriverInstance();
    }

    public void waitForDisplay(WebDriver driver,By locator){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
