package seleniumfullpractice.sectionObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablesPresenceSection {

    public TablesPresenceSection(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "courses")
    private WebElement tableCourses;

    @FindBy(css = "table[id='product']:nth-child(1)")
    private WebElement scrollingTable;

    @FindBy(id = "hide-textbox")
    private WebElement hideTextBoxButton;

    @FindBy(id = "show-textbox")
    private WebElement showTextBoxButton;

    @FindBy(name = "show-hide")
    private WebElement showHideTextBox;

    @FindBy(className = "totalAmount")
    private WebElement totalAmount;

    public WebElement getTableCourses() {
        return tableCourses;
    }

    public WebElement getScrollingTable() {
        return scrollingTable;
    }

    public WebElement getHideTextBoxButton() {
        return hideTextBoxButton;
    }

    public WebElement getShowTextBoxButton() {
        return showTextBoxButton;
    }

    public WebElement getShowHideTextBox() {
        return showHideTextBox;
    }

    public WebElement getTotalAmount() {
        return totalAmount;
    }

    
}
