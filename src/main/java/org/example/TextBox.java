package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {

    private WebDriver driver;

    private By fullNameInput = By.id("userName");
    private By emailput = By.id("userEmail");
    private By addressInput = By.id("currentAddress");


    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherFormulario(String nome, String email, String endereco) {
        driver.findElement(fullNameInput).sendKeys(nome);
        driver.findElement(emailput).sendKeys(email);
        driver.findElement(addressInput).sendKeys(endereco);


    }

    public String obterNomoMostrado() {
        return driver.findElement(By.id("name")).getText();
    }
}
