package testdemaqa;

import basetest.BaseTest;
import org.example.ButtonsPage;
import org.example.ElementsPage;
import org.example.TextBox;
import org.example.WebTabela;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilsclass.UtilsClass;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestDemoqa extends BaseTest {

    UtilsClass utilsClass = new UtilsClass(driver);
    ElementsPage elements = new ElementsPage(driver);
    TextBox textbox = new TextBox(driver);
    WebTabela  webTabela = new WebTabela(driver);



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


    }

    @Test
    public void deveAbrirRadioButtonComSucesso() throws InterruptedException {
        driver.get("https://demoqa.com/elements");

        //criar uma funcao
        ElementsPage elements = new ElementsPage(driver);
        elements.OpenRadioButton();
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

        WebElement teste = driver.findElement(By.xpath("//span[@class=\"text\" and text()=\"Web Tables\"]"));
        utilsClass.ScrollFindElement(driver, teste);
        ElementsPage elements = new ElementsPage(driver);
        elements.OpenWebTable();

        //adicionar dados na tabela
        WebTabela  webTabela = new WebTabela(driver);
        webTabela.addicionarDadosTabela("Adilson", "Silva", "adilsons265@gmail.com", "28", "70000", "test", "");

        //editar dados na tabela
        webTabela.editardados("Cierra", "Ciirra", "Teixeira", "","21", "7000", "TI", "");

        //eliminar dados
        webTabela.eliminardados("Alden", "Delete");
        Thread.sleep(2000);

    }

    @Test
    public void testDoubleClickButton() throws InterruptedException {

        ElementsPage elements = new ElementsPage(driver);
        elements.OpenButtons();

        //fazer dublo click
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.DoDubleClick();

        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());
        //assertEquals(buttonsPage.getDoubleClickMessageText(), "You have done a right click");

        //fazer click direito
        buttonsPage.DoRightClick();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());
        //assertEquals(buttonsPage.getDoubleClickMessageText(), "You have done a right click");

        //click
        buttonsPage.DoClickMe();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());
        //assertEquals(buttonsPage.getDoubleClickMessageText(), "You have done a dynamic click");
    }






}
