package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = " http://tutorialsninja.com/demo/index.php? ";

    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Desktops']"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']//option[contains(text(),'Model (Z - A)')]"));
        List<WebElement> productList = driver.findElements(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productList) {
            String productName = product.getText(); // Assuming product name is displayed as text on the web page
            productNames.add(productName);
            List<String> sortedProductNames = new ArrayList<>(productNames);
            Collections.sort(sortedProductNames, Collections.reverseOrder());
            boolean isDescending = productNames.equals(sortedProductNames);
            if (isDescending) {
                System.out.println("Product names are arranged in descending order.");
            } else {
                System.out.println("Product names are not arranged in descending order.");
            }

        }

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Desktops']"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']//option[contains(text(),'Model (A - Z)')]"));
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        String expected = "HP LP3065";
        Assert.assertEquals(expected, actual);

//        String year = "2022";
//        String month = "11";
//        String date = "30";
//        // Open the celender
//        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));


        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actual1= getTextFromElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        String expected1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(expected, actual);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        String actual2= getTextFromElement(By.xpath("//h1[contains(text(),' (1.00kg)')]"));
        String expected2 = "Shopping Cart         (1.00kg) ";
        Assert.assertEquals(expected, actual);

        //2.12 Verify the Product name "HP LP3065"
        String actual3= getTextFromElement(By.xpath("//a[text()='HP LP3065']"));
        String expected3 = "HP LP3065";
        Assert.assertEquals(expected, actual);

        //verify the date


        //2.14 Verify the Model "Product21"
        String actual4= getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        String expected4 = "Product 21";
        Assert.assertEquals(expected, actual);

        //2.15 Verify the Todat "£74.73"
        String actual5= getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String expected5 = "$122.00";
        Assert.assertEquals(expected, actual);


    }
}

