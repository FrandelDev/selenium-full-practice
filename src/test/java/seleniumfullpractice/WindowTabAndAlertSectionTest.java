package seleniumfullpractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import seleniumfullpractice.sectionObjects.WindowTabAndAlertSection;

public class WindowTabAndAlertSectionTest {

    BaseConfig config;
    WebDriver driver;
    WindowTabAndAlertSection windowTabAndAlertSection;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver  = BaseConfig.getDriverInstance();
        windowTabAndAlertSection = new WindowTabAndAlertSection(driver);
        // config.initialize();
    }

    @Test
    public void can_go_to_new_window() throws InterruptedException {
        WebElement openWindowButton = windowTabAndAlertSection.getOpenWindowButton();
        openWindowButton.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowsId = windows.iterator();
        String parentWindowId = windowsId.next();
       
        String childWindowId = windowsId.next();
        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().window(childWindowId).getCurrentUrl(), "https://www.qaclickacademy.com/");
        driver.switchTo().window(parentWindowId);
    }

    @Test
    public void can_go_to_new_tab() throws InterruptedException {
        WebElement openTabButton = windowTabAndAlertSection.getOpenTabButton();
        openTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> tabsId = tabs.iterator();
       String parentTabId =tabsId.next();
        String childTabId = tabsId.next();
        Assert.assertEquals(driver.switchTo().window(childTabId).getCurrentUrl(), "https://www.qaclickacademy.com/");
        driver.switchTo().window(parentTabId);
    }

    @Test
    public void alert_contain_text() {
        WebElement alertButton = windowTabAndAlertSection.getAlertButton();
        windowTabAndAlertSection.getInputText().sendKeys("Frandel");
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Hello Frandel, share this practice page and share your knowledge");
        alert.accept();
    }
    @Test
    public void can_decline_alert(){
        WebElement confirmButton = windowTabAndAlertSection.getConfirmButton();
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty()); //If get text, alert  is present.
        alert.dismiss();
        Assert.assertThrows(NoAlertPresentException.class,()->driver.switchTo().alert());
    }
}
