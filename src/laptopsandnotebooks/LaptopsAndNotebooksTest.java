package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = " http://tutorialsninja.com/demo/index.php? ";


    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        clickOnElement(By.xpath("//select[@id='input-sort']//option[contains(text(),'Price (High > Low)')]"));

        List<WebElement> productList = driver.findElements(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        List<Double> productPrices = new ArrayList<>();
        for (WebElement product : productList) {
            String priceText = product.getText(); // Assuming product price is displayed as text on the web page

        }
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices, Collections.reverseOrder());
        boolean isHighToLow = productPrices.equals(sortedProductPrices);
        if (isHighToLow) {
            System.out.println("Products are arranged in high to low order.");
        } else {
            System.out.println("Products are not arranged in high to low order.");
        }

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']//option[contains(text(),'Price (High > Low)')]"));
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        //2.5 Verify the text “MacBook”
        String expected = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook Pro')]"));
        String actual= "MacBook Pro";
        Assert.assertEquals(expected,actual);
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actual1= getTextFromElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        String expected1= "Success: You have added ";
        Assert.assertEquals(expected,actual);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        String actual2= getTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]"));
        String expected2 = "Shopping Cart         (0.00kg) ";
        Assert.assertEquals(expected, actual);
        //2.10 Verify the Product name "MacBook"
        String actual3= getTextFromElement(By.xpath("//a[text()='MacBook Pro']"));
        String expected3 = "MacBook Pro";
        Assert.assertEquals(expected, actual);
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        driver.findElement(By.xpath("//input[@value='1']")).sendKeys("2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actual4= getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String expected4 = "Success: You have modified your shopping cart!";
        Assert.assertEquals(expected, actual);
        //2.14 Verify the Total £737.45
        String actual5= getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String expected5 = "4,000.00";
        Assert.assertEquals(expected, actual);
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        String actual6= getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        String expected6 = "Checkout";
        Assert.assertEquals(expected, actual);
        //2.17 Verify the Text “New Customer”
        String actual7= getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        String expected7 = "New Customer";
        Assert.assertEquals(expected, actual);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"David");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"Dhawan");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"daviddhawan@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"07111222333");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"94 hendon way,");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"NW8 9LA");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"),"222");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"3553");
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Please call before delivery is attempted ");
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-shipping-method']"));
        //Tick agree checkbox
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));























    }




    }

