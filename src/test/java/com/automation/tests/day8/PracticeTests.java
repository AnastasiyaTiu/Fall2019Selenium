package com.automation.tests.day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

/**
 * Create a class called PracticeTests
 *
 * - setup before/after methods
 *     - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 *     - in after method - just close webdriver.
 *
 * - create a test called loginTest
 *     - go to "Form Authentication" page
 *     - enter valid credentials
 *        username: tomsmith
 *        password: SuperSecretPassword
 *
 *     - verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */
public class PracticeTests {
    private WebDriver driver;
    /**
     * We put @Test annotation to make methods executable as tests
     */
    @Test//create a test called loginTest
    public void loginTest() throws InterruptedException {
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        Thread.sleep(4000);
        //BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        Thread.sleep(4000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void forgotPasswordTest() throws InterruptedException {
        driver.findElement(By.linkText("Forgot Password")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys("testemail@mail.com", Keys.ENTER);
        Thread.sleep(3000);

        String actual = driver.findElement(By.tagName("h4")).getText();
        String expected = "Your e-mail's been sent!";
        Assert.assertEquals(actual, expected, "message is not match");


    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */
    @Test
    public void checkTest1() throws InterruptedException {
        driver.findElement(By.linkText("CheckBoxes")).click();

        // locator for specific checkbox, xpath: // input[1], cssSelector: input: nth-Of-type(1)
        // input[]
        // collect all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        Thread.sleep(3000);

        checkboxes.get(0).click(); // to click on first checkbox

        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected");

        Thread.sleep(3000);
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
