package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrokeLink {
    private WebDriver driver;

    private By validteLink = By.xpath("//a[text()=\"Click Here for Valid Link\"]");
    private By brokeLink = By.xpath("//a[text()=\"Click Here for Broken Link\"]");

    // construtor
    public BrokeLink(WebDriver driver) {
        this.driver = driver;
    }

    public void validtLinks() {
        driver.findElement(validteLink).click();
        WebElement header = driver.findElement(By.xpath("//div[@class='main-header' and text()='Elements']"));
        Assert.assertTrue(header.isDisplayed(), "Página não carregou corretamente");
    }

    public void brokeLinks() {
        driver.findElement(validteLink).click();
        WebElement header = driver.findElement(By.xpath("//div[@class=\"example\"]//h3[text()=\"Status Codes\"]"));
        Assert.assertTrue(header.isDisplayed(), "Página não carregou corretamente");
    }
}
