package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;



public class MenTest extends Utility {

        String baseUrl = " https://magento.softwaretestingboard.com/";

        @Before
        public void setup() {
            openBrowser(baseUrl);
        }

        @Test
        public void userShouldAddProductSuccessfullyToShoppingCart() {
            // Mouse Hover on the 'Men' Menu
            WebElement menMenu = driver.findElement(By.linkText("Men"));
            hoverOverElement(menMenu);

            // Mouse Hover on 'Bottoms'
            WebElement bottomsMenu = driver.findElement(By.linkText("Bottoms"));
            hoverOverElement(bottomsMenu);


            //Click on the ‘Pants’
            clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

            // product name ‘Cronus Yoga Pant’ and click on the size 32.
            clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

            //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the Color Black.
            clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));


            // Mouse Hover on the product 'Cronus Yoga Pant' and click on the Color
            WebElement colorOption = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
            colorOption.click();

            //click on the 'Add To Cart' Button
            WebElement selectColor = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
            selectColor.click();

            // Verify the message 'You added Cronus Yoga Pant to your shopping cart.'

        //    String cartMessage = getAddedToCartMessage();
          //  assert cartMessage.contains("You added Cronus Yoga Pant to your shopping cart.");

            // Click on the 'shopping cart
            goToShoppingCart();

            // Verify the text
            WebElement cartTitle = driver.findElement(By.xpath("//h1[text()='Shopping Cart']"));
            assert cartTitle.getText().equals("Shopping Cart");

            // Verify the product name 'Cronus Yoga Pant'
            //verifyCartDetails("Cronus Yoga Pant", "32", "Black");
        }


        @After
        public void tearDown() {
            //closeBrowser();
        }

    }

