package utilsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilsClass {
    private WebDriver driver;
    protected WebDriverWait wait;

    public UtilsClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
    * de forma a facilitar e criar um codigo mais limpo resolvi escriver os
    * WebElement para depois serem chamados nas outras abas e sera preciso inserir
    * apenas o elemento web (id, name, xpath,  class, etc)
    * */

    public WebElement findElementByname(String elementName){
        return driver.findElement(By.name(elementName));
    }
    public WebElement findElementByid(String elementId){
        return driver.findElement(By.id(elementId));
    }
    public WebElement findElementBycssSelector(String elementCssSelector){
        return driver.findElement(By.cssSelector(elementCssSelector));
    }
    public WebElement findElementByXPath(String elementXPath){
        return driver.findElement(By.xpath(elementXPath));
    }



    public static void ScrollFindElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
