package seleniumfullpractice.sectionObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowTabAndAlertSection {


    public WindowTabAndAlertSection(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "openwindow")
    private WebElement openWindowButton;

    @FindBy(id = "opentab")
    private WebElement openTabButton;

    @FindBy(css = "input[id='name']")
    private WebElement inputText;

    @FindBy(id = "alertbtn")
    private WebElement alertButton;

    @FindBy(id = "confirmbtn")
    private WebElement confirmButton;

    public WebElement getOpenWindowButton() {
        return openWindowButton;
    }

    public WebElement getOpenTabButton() {
        return openTabButton;
    }

    public WebElement getInputText() {
        return inputText;
    }

    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    
}
