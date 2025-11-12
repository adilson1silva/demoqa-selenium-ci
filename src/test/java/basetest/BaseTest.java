package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {


        ChromeOptions options = new ChromeOptions();

        // Configurações essenciais para rodar no background (headless)
        options.addArguments("--headless=new"); // Usa o novo modo headless do Chrome
        options.addArguments("--no-sandbox");   // Necessário para rodar no GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Evita erros de memória compartilhada
        options.addArguments("--disable-gpu");  // Desativa GPU (melhor compatibilidade)
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/elements");
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}

