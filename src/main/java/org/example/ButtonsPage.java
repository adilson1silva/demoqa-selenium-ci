package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilsclass.UtilsClass;

public class ButtonsPage {
    private WebDriver driver;
    private Actions actions;

    //Locators
    private By dubleClick = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By clickMe = By.xpath("//button[@class=\"btn btn-primary\" and text()='Click Me']");

    // Mensagens de resultado
    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClickMessage = By.id("rightClickMessage");
    private By dynamicClickMessage = By.id("dynamicClickMessage");

    //construtor
    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }


    //acoes
    public void DoDubleClick() {
        WebElement buttonDuble = driver.findElement(dubleClick);
        UtilsClass.ScrollFindElement(driver, buttonDuble);
        actions.doubleClick(buttonDuble).perform();
    }

    public void DoRightClick() {
        WebElement button = driver.findElement(rightClickBtn);
        UtilsClass.ScrollFindElement(driver, button);
        actions.contextClick().perform();
    }

    public void DoClickMe() {
        driver.findElement(clickMe).click();
    }

    // Verificações (assert helpers)
    public boolean isDoubleClickMessageDisplayed() {
        return driver.findElement(doubleClickMessage).isDisplayed();
    }

    public boolean isRightClickMessageDisplayed() {
        return driver.findElement(rightClickMessage).isDisplayed();
    }

    public boolean isDynamicClickMessageDisplayed() {
        return driver.findElement(dynamicClickMessage).isDisplayed();
    }

    public String getDoubleClickMessageText() {
        return driver.findElement(doubleClickMessage).getText();
    }

    public String getRightClickMessageText() {
        return driver.findElement(rightClickMessage).getText();
    }

    public String getDynamicClickMessageText() {
        return driver.findElement(dynamicClickMessage).getText();
    }


}
