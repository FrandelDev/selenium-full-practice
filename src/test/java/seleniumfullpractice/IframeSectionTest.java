package seleniumfullpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import seleniumfullpractice.sectionObjects.IframeSection;

public class IframeSectionTest {

    BaseConfig config;
    WebDriver driver;
    IframeSection iframeSection;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        iframeSection = new IframeSection(driver);
        // config.initialize();
    }

    @Test
    public void access_to_iframe() {
        WebElement iframe = iframeSection.getIframe();
        driver.switchTo().frame(iframe);
        String headerTextOfIframe = driver.findElement(By.cssSelector(".header-text span")).getText();

        Assert.assertEquals(headerTextOfIframe, "An Academy to Learn Earn & Shine  in your QA Career");
        driver.switchTo().defaultContent();
    }

}
