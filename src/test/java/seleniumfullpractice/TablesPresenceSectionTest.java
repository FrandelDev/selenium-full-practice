package seleniumfullpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import seleniumfullpractice.sectionObjects.TablesPresenceSection;

public class TablesPresenceSectionTest {

    BaseConfig config;
    WebDriver driver;
    TablesPresenceSection tablesPresenceSection;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        tablesPresenceSection = new TablesPresenceSection(driver);
        // config.initialize();
    }

    @Test
    public void are_tables_present() {
        WebElement tableCourses = tablesPresenceSection.getTableCourses();
        WebElement scrollingTable = tablesPresenceSection.getScrollingTable();

        Assert.assertTrue(tableCourses.isDisplayed());
        Assert.assertTrue(scrollingTable.isDisplayed());
    }

    @Test
    public void can_do_scroll_in_table() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean canScroll = (Boolean) js.executeScript(
                "return document.querySelector('.tableFixHead').scrollHeight > document.querySelector('.tableFixHead').clientHeight");
        Assert.assertTrue(canScroll);
    }

    @Test
    public void hidde_textbox() {
        WebElement hideTexBoxButton = tablesPresenceSection.getHideTextBoxButton();
        WebElement textbox = tablesPresenceSection.getShowHideTextBox();
        hideTexBoxButton.click();
        Assert.assertFalse(textbox.isDisplayed());
    }

    @Test
    public void show_textbox() {
        WebElement showTexBoxButton = tablesPresenceSection.getShowTextBoxButton();
        WebElement textbox = tablesPresenceSection.getShowHideTextBox();
        showTexBoxButton.click();
        Assert.assertTrue(textbox.isDisplayed());
    }
}
