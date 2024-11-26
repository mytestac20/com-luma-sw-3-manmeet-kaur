
public class GearTest extends Utility {


    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldAddProductSuccessFullyToShoppingCart() {

        // click on consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        //Mouse Hover on the ‘Gear’ Menu

        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

        //Click on the ‘Bags’
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));


        //Change the Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"), "3");

        // * * Click on the ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String actMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Invalid  message", "Overnight Duffle", actMessage);

        // Click on the ‘shopping cart’ Link into  message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the product name ‘Overnight Duffle’

        String productNames = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        verifyText("Invalid Product Name", "Overnight Duffle", productNames);


        //Verify the Qty is ‘3’
        String expected = "3";
        String actual = driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value");
        verifyText("Invalid Text:", expected, actual);

        //Verify the product price ‘$135.00’
        String actualPriceOfProduct = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        verifyText("Invalid Price", "$135.00", actualPriceOfProduct);


        //Change the Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement((By.xpath("//input[@class='input-text qty']")), "5");


        //* Click on the ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));


        //Verify the product price ‘$225.00’
        String expectedProductPrice = "$225.00";
        String actualProductPrice = getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));
        verifyText("Invalid Product Price:", actualProductPrice, expectedProductPrice);

    }


    @After
    public void tearDown() {

        closeBrowser();
    }
}


