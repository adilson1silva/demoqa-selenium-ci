package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class chooseFile {

    private WebDriver driver;


    private By chooseFileButton = By.id("uploadPicture");

    public chooseFile(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFiles() {
        WebElement openForms = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span/div/div[1]"));
        openForms.click();
        WebElement practiceForm = driver.findElement(By.xpath("//*[@id=\"item-0\"]/span"));
        practiceForm.click();

        WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", chooseFile);
        chooseFile.click();

        //abrir os os fciheiros locais
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("C:\\Users\\adils\\Downloads\\Adilson Silva (1).pdf");





    }

}
