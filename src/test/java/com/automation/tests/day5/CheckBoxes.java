package com.automation.tests.day5;


import com.automation.Utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        // <input type = "checkbox" checked = "">
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));


        // go over collection of checkBoxes
        for (int i = 0; i < checkBoxes.size(); i++) {
             // if visible                           eligible to click                  not clicked
            if(checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(1).isSelected())){
                checkBoxes.get(i).click();
                System.out.println(i+1 + "checkbox clicked");//("TEST PASSED");
            }else{
                System.out.println(i+1 + "checkbox wasn't clicked");//("TEST FAILED");
            }
        }
        BrowserUtils.wait(2);
        driver.close();
    }
}
