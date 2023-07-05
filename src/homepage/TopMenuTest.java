package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = " http://tutorialsninja.com/demo/index.php? ";

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));

    }

    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Desktops']"));
        selectMenu("Show AllDesktops");
        String actual = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        String expected = "Desktops";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Laptops & Notebooks']"));
        selectMenu("Show AllLaptops & Notebooks");
        String actual= getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        String expected= "Laptops & Notebooks";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHover(By.xpath("//a[@class='dropdown-toggle'][text()='Components']"));
        selectMenu("Show AllComponents");
        String actual= getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        String expected= "Components";
        Assert.assertEquals(expected,actual);


    }
}
