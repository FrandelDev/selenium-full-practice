package seleniumfullpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import seleniumfullpractice.sectionObjects.MousehoverSection;

public class MousehoverSectionTest {

    WebDriver driver;
    BaseConfig config;
    MousehoverSection mousehoverSection;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        mousehoverSection = new MousehoverSection(driver);
        config.initialize();
    }

    @Test
    public void hover_content_is_visible() {
        WebElement button = mousehoverSection.getButton();
        WebElement content = mousehoverSection.getHoverContent();

        Actions actions = new Actions(driver);
        Assert.assertFalse(content.findElement(By.tagName("a")).isDisplayed());
        actions.moveToElement(button).build().perform();
        Assert.assertTrue(content.findElement(By.tagName("a")).isDisplayed());
    }

    @Test
    public void can_click_hover_element() {
        WebElement button = mousehoverSection.getButton();
        WebElement content = mousehoverSection.getHoverContent();

        Actions actions = new Actions(driver);
        actions.moveToElement(button).build().perform();
        content.findElement(By.cssSelector("a:nth-child(1)")).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://rahulshettyacademy.com/AutomationPractice/#top"));
    }
}
