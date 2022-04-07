package br.rj.ricardo.test;

import br.rj.ricardo.core.DSL;
import br.rj.ricardo.core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {
    private DSL dsl;

    @Before
    public void inicializa(){
        DriverFactory.getDriver();
        dsl = new DSL();

    }

    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        Thread.sleep(5000);
        dsl.escrever("novoCampo", "Deu certo");
    }

    @Test
    public void deveUtilizarEsperaImplicita() throws InterruptedException {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//quando elemento for exibido segue teste normalmente
        dsl.clicarBotao("buttonDelay");
        dsl.escrever("novoCampo", "Deu certo");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test //aguarda até o elemento aparecer, mas se o elemento já estava na tela não irá funcionar, está é a melhor estratégia
    public void deveUtilizarEsperaExplicita() throws InterruptedException {
        dsl.clicarBotao("buttonDelay");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escrever("novoCampo", "Deu certo");
    }

}
