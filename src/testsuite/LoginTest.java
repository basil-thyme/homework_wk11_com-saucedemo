package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    /**
     * 1. userSholdLoginSuccessfullyWithValid
     * Credentials
     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify the text “PRODUCTS”
     */

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement enterUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        enterUsername.sendKeys("standard_user");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterPassword.sendKeys("secret_sauce");

        WebElement clickOnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        clickOnLogin.click();

        WebElement actualProductText = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actual = actualProductText.getText();

        String expected = "Products";
        Assert.assertEquals("Product text is not displayed", expected, actual);

    }

    /**
     * verifyThatSixProductsAreDisplayedOnPage
     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify that six products are displayed
     * on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement enterUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        enterUsername.sendKeys("standard_user");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterPassword.sendKeys("secret_sauce");

        WebElement clickOnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        clickOnLogin.click();

        // preapre an xpath to highlight six label webelements
        // Store elements in List<WebElement>
        List<WebElement> labelsListOfWebElements = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));
       // System.out.println(labelsListOfWebElements);

        ArrayList<String> list = new ArrayList<>();

        for (WebElement element : labelsListOfWebElements) {
        //    System.out.println(element.getText());
            list.add(element.getText());
        }

        //System.out.println(list);

        //Actual
        int actual = list.size();
        //System.out.println("Actual: " + actual);

        String actual1 = Integer.toString(actual);
        //Expect
        int expected = 6;

        String expected1 = Integer.toString(expected);
        //Assert

       Assert.assertEquals("Number of items are not matching", expected1, actual1);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}