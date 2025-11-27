package testdemaqa;

import basetest.BaseTest;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilsclass.UtilsClass;

import static org.testng.AssertJUnit.assertTrue;

public class TestDemoqa extends BaseTest {

    private UtilsClass utils;
    private ElementsPage elements;
    private TextBox textBox;
    private WebTabela webTabela;
    private ButtonsPage buttonsPage;
    private BrokeLink brokeLink;

    @BeforeMethod
    public void setupPages() {
        utils = new UtilsClass(driver);
        elements = new ElementsPage(driver);
        textBox = new TextBox(driver);
        webTabela = new WebTabela(driver);
        buttonsPage = new ButtonsPage(driver);
        brokeLink = new BrokeLink(driver);

        driver.get("https://demoqa.com/elements");
    }

    @Test
    public void devePreencherTextoFormularioComSucesso() {
        elements.Open_textBox();

        textBox.preencherFormulario(
                "Adilson Mendes Silva",
                "teste@gmail.com",
                "rua cardoso tavares"
        );

        WebElement submit = driver.findElement(By.id("submit"));
        utils.ScrollFindElement(driver, submit);
        submit.click();

        Assert.assertEquals(
                textBox.obterNomoMostrado(),
                "Name:Adilson Mendes Silva",
                "Nome não foi encontrado."
        );
    }

    @Test
    public void deveAbrirRadioButtonComSucesso() {
        elements.OpenRadioButton();
        // Verifique algo real aqui futuramente
    }

    @Test
    public void trabalharComWebTabela() throws InterruptedException {
        elements.OpenWebTable();

        // Adicionar dados
        webTabela.addicionarDadosTabela(
                "Adilson", "Silva", "adilsons265@gmail.com",
                "28", "70000", "test", ""
        );

        // Editar dados
        webTabela.editardados(
                "Cierra", "Ciirra", "Teixeira",
                "", "21", "7000", "TI", ""
        );

        // Remover dados
        webTabela.eliminardados("Alden", "Delete");
    }

    @Test
    public void testDoubleClickButton() {
        elements.OpenButtons();

        // Duplo clique
        buttonsPage.DoDubleClick();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());

        // Aqui deve-se acriscentar mais linha de codigo para ter um teste mais consistente

        // Clique direito
        buttonsPage.DoRightClick();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());

        // Aqui tambem

        // Clique normal
        buttonsPage.DoClickMe();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed());

        //Aqui tambem
    }

    @Test
    public void testBrokenLink() {
        elements.OpenBrokenLinks_images();
        brokeLink.brokeLinks();
    }

}
