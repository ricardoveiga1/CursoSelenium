package test;

import core.DSL;
import core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {

    private WebDriver driver;
    private DSL dsl;


    @Before
    public void inicializa(){
       DriverFactory.getDriver();
        driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=e251d");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        DriverFactory.killDriver();
    }

    @Test
    public void testAjax(){
        dsl.escrever("j_idt311:name", "Teste");
        dsl.clicarBotao("j_idt311:j_idt315");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("xxxxnãoconseguireproduir")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
    }
}
