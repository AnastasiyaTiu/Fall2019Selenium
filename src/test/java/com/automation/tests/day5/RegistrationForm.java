package com.automation.tests.day5;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);
        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword");
        driver.findElement(By.name("phone")).sendKeys("571-456-4567");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        // select gender
        genders.get(1).click(); //select male, for example

        driver.findElement(By.name("birthday")).sendKeys("01/01/1999");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);

        // Add validation

        driver.quit();
    }
}
