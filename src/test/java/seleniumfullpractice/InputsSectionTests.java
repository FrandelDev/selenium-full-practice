package seleniumfullpractice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import seleniumfullpractice.sectionObjects.InputsSection;

public class InputsSectionTests {

    private BaseConfig config = BaseConfig.getInstance();;
    private InputsSection inputsSection;
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = config.initialize();
        inputsSection = new InputsSection(driver);
    }

    @Test
    public void is_radio__clicked() {
        WebElement radio = inputsSection.getRadio2();
        System.out.println(radio);
        radio.click();
        Assert.assertTrue(radio.isSelected());
    }

    @Test
    public void can_pick_suggestion() throws InterruptedException{
        WebElement autocomplete = inputsSection.getAutocomplete();
        autocomplete.sendKeys("Alb");
        config.waitForDisplay(driver, By.className("ui-menu-item"));
        autocomplete.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        Object data = executor.executeScript("return document.querySelector('.ui-menu-item:nth-child(1)').textContent");
        driver.findElement(By.cssSelector(".ui-menu-item:nth-child(1)")).getText();
        Assert.assertEquals(data, "Albania");
    }

    @Test
    public void select_dropdown_option(){
        WebElement dropdown = inputsSection.getDropdown();
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option1");
    }

    @Test
    public void are_checkboxes_selected(){
       List<WebElement> checkboxes = inputsSection.getCheckboxes();
       checkboxes.forEach((checkbox)->{
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
       });
    }

    
}
