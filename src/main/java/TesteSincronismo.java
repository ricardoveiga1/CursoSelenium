import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {

    private WebDriver driver;
    private DSL dsl;


    @Before
    public void inicializa(){
        System.setProperty("webdriver.gecko.driver", "/Users/ricardoveiga/Drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);

    }

    @After
    public void finaliza(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escrever("novoCampo", "Deu certo");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//quando elemento for exibido segue teste normalmente
        dsl.clicarBotao("buttonDelay");
        dsl.escrever("novoCampo", "Deu certo");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test //aguarda até o elemento aparecer, mas se o elemento já estava na tela não irá funcionar, está é a melhor estratégia
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu certo");
    }

}
