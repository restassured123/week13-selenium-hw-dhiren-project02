package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php? ";


    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;

            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        String expected = "Register Account";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        String actual = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        String expected = "Returning Customer";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Radhe");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Krishna");
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "radheradheradhe@universe.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "0000000000");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "jayshreekrishna");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "jayshreekrishna");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String expected = "Your Account Has Been Created!";
        Assert.assertEquals(expected, actual);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("logout");
        //3.16 Verify the text “Account Logout”
        String actual1 = getTextFromElement(By.xpath("//span[contains(text(),'My Account')]"));
        String expected1 = "Account Logout";
        Assert.assertEquals(expected, actual);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "radheradheradhe@universe.com");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "jayshreekrishna");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String actual2 = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        String expected2 = "My Account";
        Assert.assertEquals(expected2, actual2);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String eLogout = "Account Logout";
        String aLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(eLogout, aLogout);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {
        closingBrowser();
    }
}
