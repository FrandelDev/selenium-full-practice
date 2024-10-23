package seleniumfullpractice.sectionObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframeSection {

    public IframeSection(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "courses-iframe")
    private WebElement iframe;

    public WebElement getIframe() {
        return iframe;
    }

    

}
