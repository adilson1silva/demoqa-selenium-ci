package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebTabela {
    private WebDriver driver;

    private By FirstName = By.id("firstName");
    private By LastName = By.id("lastName");
    private By Email = By.id("userEmail");
    private By Age = By.id("age");
    private By Salary = By.id("salary");
    private By Departament = By.id("department");
    private By Submit  = By.id("submit");


    public WebTabela(WebDriver driver) {
        this.driver = driver;
    }


    //adicionar dados na tabela
    public void addicionarDadosTabela(String firstName, String lastName, String email, String age, String salary, String departament, String submit){

        WebElement buttonAdd = driver.findElement(By.id("addNewRecordButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonAdd);
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
    * escolher uma pessoa e depois editar os dados dela
    * */

    public WebElement tratarDados(String nomeDaAcao, String acao){
        String spath = String.format("//div[@class=\"rt-tr -odd\"][.//div[@class=\"rt-td\" and text()='%s']]//span[@title='%s']",
                nomeDaAcao, acao);

        return driver.findElement(By.xpath(spath));
    }

    public void editardados(String nomeDaAcao, String novofirstName, String novolastName, String novoemail, String novoage, String novosalary, String novodepartament, String submit) throws InterruptedException {
        WebElement buttonEditar = tratarDados(nomeDaAcao, "Edit");
        buttonEditar.click();

        Thread.sleep(2000);

        // Campos
        WebElement inputFirstName = driver.findElement(FirstName);
        WebElement inputLastName = driver.findElement(LastName);
        WebElement inputEmail = driver.findElement(Email);
        WebElement inputAge = driver.findElement(Age);
        WebElement inputSalary = driver.findElement(Salary);
        WebElement inputDepartment = driver.findElement(Departament);

        // Limpar antes de preencher
        inputFirstName.clear();
        inputLastName.clear();
        inputEmail.clear();
        inputAge.clear();
        inputSalary.clear();
        inputDepartment.clear();

        // Preencher novos dados
        inputFirstName.sendKeys(novofirstName);
        inputLastName.sendKeys(novolastName);
        inputEmail.sendKeys(novoemail);
        inputAge.sendKeys(novoage);
        inputSalary.sendKeys(novosalary);
        inputDepartment.sendKeys(novodepartament);

        driver.findElement(Submit).click();
    }

    public void eliminardados(String nomeDaAcao, String acao){
        WebElement buttonDelete = tratarDados("Kierra", "Delete");
        buttonDelete.click();

    }


}


//editar =//div[@class="rt-tr -odd"][.//div[@class="rt-td" and text()='Kierra']]//span[@title='Edit']
//delete = //div[@class="rt-tr -odd"][.//div[@class="rt-td" and text()='Kierra']]//span[@title='Delete']