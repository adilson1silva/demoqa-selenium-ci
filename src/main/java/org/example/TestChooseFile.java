package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestChooseFile {

    private WebDriver driver;

    public TestChooseFile(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFiles() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Acessar o formulário
        driver.get("https://demoqa.com/forms");

        // Acessar o "Practice Form"
        WebElement practiceForm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"text\" and text()=\"Practice Form\"]")));
        practiceForm.click();

        // Esperar até que o botão de upload esteja visível
        WebElement chooseFile = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadPicture")));

        // Rolar para o elemento
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView(true);", chooseFile);

        // Selecionar o arquivo
        chooseFile.click();

        // Aguardar o input do tipo file estar disponível
        WebElement upload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='file']")));
        upload.sendKeys("C:\\Users\\adils\\Downloads\\Adilson Silva (1).pdf");  // Substitua com o caminho real do arquivo
    }
}

