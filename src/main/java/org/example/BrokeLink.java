package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrokeLink{
    private WebDriver driver;

    private By validteLink = By.xpath("//a[text()=\"Click Here for Valid Link\"]");
    private By brokeLink = By.xpath("//a[text()=\"Click Here for Broken Link\"]");
    private By newPageValidLink = By.xpath("//div[@class=\"card-body\"]//h5[text()=\"Elements\"]");
    private By getNewPageBrokeLink = By.xpath("//div[@class=\"example\"]//h3[text()=\"Status Codes\"]");

    // construtor
    public BrokeLink(WebDriver driver) {
        this.driver = driver;
    }

    public void validtLinks() {
        driver.findElement(validteLink).click();
        WebElement header = driver.findElement(newPageValidLink);
        Assert.assertTrue(header.isDisplayed(), "A página não carregou corretamente");
    }

    public void brokeLinks() {
        driver.findElement(brokeLink).click();
        WebElement header = driver.findElement(getNewPageBrokeLink);
        Assert.assertTrue(header.isDisplayed(), "A página não carregou corretamente");
    }
}
