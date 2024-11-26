package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static browserfactory.BaseTest.driver;

/**
 * 4. Write down the following test in the WomenTestclass
 *  1. verifyTheSortByProductNameFilter()
 *  * Mouse Hover on the ‘Women’ Menu
 *  * Mouse Hover on the ‘Tops’
 *  * Click on the ‘Jackets’
 *  * Select Sort By filter “Product Name”
 *  * Verify the product name displayed in
 *  alphabetical order
 *  2. verifyTheSortByPriceFilter()
 *  * Mouse Hover on the ‘Women’ Menu
 *  * Mouse Hover on the ‘Tops’
 *  * Click on the ‘Jackets’
 *  * Select Sort By filter “Price”
 *  * Verify the product price displayed in
 *  Low to High
 */

public class WomenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        // Mouse hover on 'Women' Menu
        WebElement womenMenu = driver.findElement(By.linkText("Women"));
        hoverOverElement(womenMenu);

        // Mouse hover on 'Tops'
        WebElement topsMenu = driver.findElement(By.linkText("Tops"));
        hoverOverElement(topsMenu);

        // Click on 'Jackets'
        WebElement jacketsLink = driver.findElement(By.linkText("Jackets"));
        jacketsLink.click();

        // Select Sort By filter "Product Name"
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        //Create the object of select class
        Select select = new Select(dropDown);
        //Select by visible text
        select.selectByVisibleText("Price");

        // Verify the product names are in alphabetical order
        // assert verifySortedProductNames();

        //* Select Sort By filter “Product Name”
        driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        //Select by visible text*/
        select.selectByVisibleText("Product Name");


    }

    @Test
    public void verifyTheSortByPriceFilter() {
        // Mouse hover on 'Women' Menu
        WebElement womenMenu = driver.findElement(By.linkText("Women"));
        hoverOverElement(womenMenu);

        // Mouse hover on 'Tops'
        WebElement topsMenu = driver.findElement(By.linkText("Tops"));
        hoverOverElement(topsMenu);

        // Click on 'Jackets'
        WebElement jacketsLink = driver.findElement(By.linkText("Jackets"));
        jacketsLink.click();

        // Select Sort By filter "Price"
        selectSortByFilter(By.id("sorter"), "Price");

        // Verify the product prices are sorted from Low to High
        //assert verifySortedProductPrices();
        //* Select Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        //Create the object of select class
        Select select = new Select(dropDown);
        //Select by visible text
        select.selectByVisibleText("Price");

        // Verify the product price displayed in Low to High
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));

        List<String> actualPrice = new ArrayList<>(); // add actual price in this list
        for (WebElement price : priceElements) {
            actualPrice.add(price.getText());
        }

        List<String> expectedPriceOrder = new ArrayList<>(actualPrice);
        Collections.sort(expectedPriceOrder);
        Assert.assertEquals("Price are not displayed in the Low to High order", expectedPriceOrder, actualPrice);
    }



    @After
    public  void  tearDown(){
        //closeBrowser();
    }


}

