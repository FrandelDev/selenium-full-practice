package seleniumfullpractice.sectionObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MousehoverSection {

    public MousehoverSection(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "mousehover")
    private WebElement button;

    @FindBy(className = "mouse-hover-content")
    private WebElement hoverContent;

    

    public WebElement getButton() {
        return button;
    }



    public WebElement getHoverContent() {
        return hoverContent;
    }
    
}
