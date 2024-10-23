package seleniumfullpractice.sectionObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputsSection {


    public InputsSection(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input[value='radio2']")
   private WebElement radio2;

    @FindBy(css = "input[id='autocomplete']")
   private WebElement autocomplete;

    @FindBy(id = "dropdown-class-example")
   private WebElement dropdown;

    @FindBy(css = "fieldset > label > input[type='checkbox']")
   private List<WebElement> checkboxes;


    public WebElement getRadio2() {
        return radio2;
    }

    public WebElement getAutocomplete() {
        return autocomplete;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

}
