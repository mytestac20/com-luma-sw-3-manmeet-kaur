package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



/**
 * 2. Create the package utilities and create the class
 *  with the name ‘Utility’ inside the ‘utilities’
 *  package. And write all the utility methods in it.
 */

public class Utility extends BaseTest {
    // method for mouse hover on menu
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void  mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
    }


    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }


    // Method to select a product filter by name
    public void selectSortByFilter(By by,String text) {
        WebElement sortByDropdown = driver.findElement(by); // locate the dropdown
        sortByDropdown.click(); // open the sortByDropdown

        // Find the filter option by the text and click on it
        WebElement filterOption = driver.findElement(By.xpath("//option[text()='" + text + "']"));
        filterOption.click();
    }


    public void sendTextToElement (By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void  verifyText(By by, String text){
        driver.findElement(by).sendKeys(text);


    }

    public void goToShoppingCart(){
        WebElement cartbutton= driver.findElement(By.id("shopping cart"));
        cartbutton.click();
    }
    public void getAddedToCartMessage(){

    }

    public void verifyAddedToCartAndGoTOCart(){
        String cartMessage = getAddedToCartMessage();
        String expectedMessage = "text";
        assert cartMessage.contains(expectedMessage);
    }

}