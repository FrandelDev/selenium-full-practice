package seleniumfullpractice.sectionObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinkSection {

    public BrokenLinkSection(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#gf-BIG a")
    List<WebElement> links;

    public List<WebElement> getLinks() {
        return links;
    }

    
}
