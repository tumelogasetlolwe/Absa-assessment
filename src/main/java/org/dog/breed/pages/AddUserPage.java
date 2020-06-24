package org.dog.breed.pages;

import org.dog.breed.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddUserPage {

    WebDriver driver;


    public AddUserPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickAddUserLink(String key) {

        try {
            WebElement xpath = driver.findElement(By.xpath(Utility.fetchPropertyValue(key)));
            xpath.click();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void passValues(String key, String data) {
        try {
            WebElement xpath = driver.findElement(By.xpath(Utility.fetchPropertyValue(key)));
            xpath.sendKeys(data);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  boolean isUserListTablePresentOnThePage(String text) {
        boolean isPresent = false;
        try {

            if(driver.findElements(By.xpath(Utility.fetchPropertyValue(text))).size() != 0){
                isPresent = true;
            } else
                isPresent = false;

        } catch (Exception e) {
           System.out.println(e);
        }

        return  isPresent;
    }

    public void sleep(int sec) {

        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}








