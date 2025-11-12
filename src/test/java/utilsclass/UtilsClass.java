package utilsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilsClass {
    private WebDriver driver;

    public UtilsClass(WebDriver driver) {
        this.driver = driver;
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



    public void ScrollFindElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
