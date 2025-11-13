package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilsclass.UtilsClass;

public class ElementsPage {
    private WebDriver driver;

    private By TextBox = By.xpath("//span[@class=\"text\" and text()=\"Text Box\"]");
    private By RadioButton = By.xpath("//span[@class=\"text\" and text()=\"Radio Button\"]");
    private By WEbTable = By.xpath("//span[@class=\"text\" and text()=\"Web Tables\"]");
    private By Buttons = By.xpath("//span[@class=\"text\" and text()=\"Buttons\"]");
    private By BrokenLinks_images = By.xpath("//span[@class=\"text\" and text()=\"Broken Links - Images\"]");
    private By DynamicProperties = By.xpath("//span[@class=\"text\" and text()=\"Dynamic Properties\"]");

        public  ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void  Open_textBox() {
        driver.findElement(TextBox).click();
    }
    public void  OpenRadioButton() {
        driver.findElement(RadioButton).click();
    }
    public void  OpenWebTable() {
        driver.findElement(WEbTable).click();
    }
    public void  OpenButtons() {
        WebElement button = driver.findElement(Buttons);
        UtilsClass.ScrollFindElement(driver, button);
        button.click();
    }
    public void  OpenBrokenLinks_images() {
        driver.findElement(BrokenLinks_images).click();
    }
    public void  OpenDynamicProperties() {
        driver.findElement(DynamicProperties).click();
    }


}
