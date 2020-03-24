package com.automation.tests.day6;

import com.automation.Utilities.BrowserUtils;
import com.automation.Utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); // to extend dropdown

         // <a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(2);

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for(WebElement link : allLinks){
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
            BrowserUtils.wait(2);
        }

        driver.findElement(By.linkText("Etsy")).click();  // to click on option


        BrowserUtils.wait(3);
        driver.quit();
    }
}
