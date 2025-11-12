package testdemaqa;

import basetest.BaseTest;
import org.example.ElementsPage;
import org.example.TextBox;
import org.example.WebTabela;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilsclass.UtilsClass;

public class TestDemoqa extends BaseTest {

    UtilsClass utilsClass = new UtilsClass(driver);


    @Test
    public void devepreencherTextoFormularioComSucesso() throws InterruptedException {
        driver.get("http://demoqa.com/elements");

        //aqui criei uma funcao para abrir o Text Box
        ElementsPage elements = new ElementsPage(driver);
        elements.Open_textBox();

        // vou criar mais uma funcao para para preencher os dados
        TextBox textbox = new TextBox(driver);
        textbox.preencherFormulario("Adilson Mendes Silva", "teste@gmail.com", "rua cardoso tavares");

        WebElement submit = driver.findElement(By.id("submit"));
        utilsClass.ScrollFindElement(driver, submit);
        submit.click();


        String resultado = textbox.obterNomoMostrado();
        Assert.assertEquals(resultado, "Name:Adilson Mendes Silva", "Nome nao foi encontrado.");

        Thread.sleep(5000);

    }

    @Test
    public void deveAbrirRadioButtonComSucesso() throws InterruptedException {
        driver.get("https://demoqa.com/elements");

        //criar uma funcao
        ElementsPage elements = new ElementsPage(driver);
        elements.OpenRadioButton();
        Thread.sleep(5000);
    }



    /*
    * web tabela acoes a realizar
    *  - adicionar dados tabela
    *  - remover dados na tabela
    *  - editar dados na tabela
    * */
    @Test
    public void TrabalharWebTabela() throws InterruptedException {
        driver.get("http://demoqa.com/elements");
        Thread.sleep(2000);

        WebElement teste = driver.findElement(By.xpath("//span[@class=\"text\" and text()=\"Web Tables\"]"));
        utilsClass.ScrollFindElement(driver, teste);
        ElementsPage elements = new ElementsPage(driver);
        elements.OpenWebTable();

        WebTabela  webTabela = new WebTabela(driver);
        webTabela.addicionarDadosTabela("Adilson", "Silva", "adilsons265@gmail.com", "28", "70000", "test", "");




    }


}
