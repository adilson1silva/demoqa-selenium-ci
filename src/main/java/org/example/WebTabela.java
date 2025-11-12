package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTabela {
    private WebDriver driver;

    private By FirstName = By.id("firstName");
    private By LastName = By.id("lastName");
    private By Email = By.id("userEmail");
    private By Age = By.id("age");
    private By Salary = By.id("salary");
    private By Departament = By.id("departament");
    private By Submit  = By.id("submit");


    public WebTabela(WebDriver driver) {
        this.driver = driver;
    }


    //adicionar dados na tabela
    public void addicionarDadosTabela(String firstName, String lastName, String email, String age, String salary, String departament, String submit){

        WebElement buttonAdd = driver.findElement(By.id("addNewRecordButton"));
        buttonAdd.click();

        driver.findElement(FirstName).sendKeys(firstName);
        driver.findElement(LastName).sendKeys(lastName);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Age).sendKeys(age);
        driver.findElement(Salary).sendKeys(salary);
        driver.findElement(Departament).sendKeys(departament);
        driver.findElement(Submit).click();
    }

    /*
    *editar dados na tabela
    *
    * */





}
