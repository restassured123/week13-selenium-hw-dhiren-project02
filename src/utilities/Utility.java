package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /**
     * This method will get the text
     */

    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    /**
     * This method will select the option by visible value
     */

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);

        /**
         * Mouse Hover
         */
    }

    public void mouseHover(By by) {
        WebElement text1 = driver.findElement(by);
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).click().build().perform();


    }


}