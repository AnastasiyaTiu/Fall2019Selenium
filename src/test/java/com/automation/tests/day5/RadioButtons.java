package com.automation.tests.day5;

import com.automation.Utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        // <input type = "radio">
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for(WebElement radioButton : radioButtons){
            //<input type="radio" id="yellow" name="color">
            String id = radioButton.getAttribute("id");

            // return true if button already clicked
            boolean isSelected = radioButton.isSelected();

            // to check if button can be clicked
            // returns true if you can click on the button
            if(radioButton.isEnabled()){

            radioButton.click();
            System.out.println("Clicked on " + id);
            BrowserUtils.wait(1);
        }else {
                System.out.println("Button is disabled, not clicked :: " + id);
            }
        }
        //driver.quit();
    }
}
