package com.automation.tests.day5;

import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {
    static WebDriver driver = DriverFactory.createDriver("chrome");
    public static void main(String[] args) throws Exception {
        //selectByTextTest();
       // selectByValueTest();
       // selectByIndex();
        multiSelectedDropDownTest();
    }

    public static void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    public static void selectByTextTest() throws InterruptedException {
        setup();
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        driver.close();
    }

    public static void selectByValueTest() throws Exception{
        setup();
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        Thread.sleep(2000);
        String expected = "District of Columbia";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        driver.close();
    }

    public static void selectByIndex() throws Exception{
        setup();
        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);
        Thread.sleep(2000);

        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();

        String expectedValue = "AL";
        String actualValue = select.getFirstSelectedOption().getAttribute("value");

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

        System.out.println("expected value: " + expectedValue);
        System.out.println("actual value: " + actualValue);
        driver.close();
    }

    public static void multiSelectedDropDownTest() throws Exception{
        setup();
        Thread.sleep(3000);

        Select select = new Select(driver.findElement(By.name("L anguages")));

        List<WebElement> options = select.getOptions();
        for(WebElement option: options){
            Thread.sleep(1000);
            select.selectByVisibleText(option.getText());
        }
        driver.close();
    }
}
