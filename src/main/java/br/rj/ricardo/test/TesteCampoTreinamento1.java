package br.rj.ricardo.test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento1 {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "/Users/ricardoveiga/Drivers/geckodriver");
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "/Users/ricardoveiga/Drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }
    @After
    public void finaliza(){

        driver.quit();
    }

    @Test
    public void testeTextField(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void deveIntegarirComTextArea(){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");
        Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void deveIntegarirComRadioButton(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void deveIntegarirComCheckbox(){
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
    }

    @Test
    public void deveIntegarirComCombo(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
//		combo.selectByIndex(2);
//		combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");

        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
    }

    @Test
    public void deveVerificarValoresCombo(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        //Verificação mais completa
        boolean encontrou = false;
        for(WebElement option: options) {
            if(option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo(){

        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        //validando 3 itens no select
        List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectOptions.size());

        //fazendo um deselect em um item
        combo.deselectByVisibleText("Corrida");
        allSelectOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectOptions.size());
    }

    //value do botão, validando texto com click
    @Test
    public void deveinteragirComBotoes(){
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    //use Assert.fail(); ou @Ignore quando quiser completar o teste depois, para não deixar falso positivo na bateria de testes
    @Test
    //@Ignore  depois procurar a solução, o teste continua executando
    public void deveinteragirComLinks(){
        driver.findElement(By.linkText("Voltar")).click();
        //Assert.fail();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        driver.quit();
    }


    @Test
    public void deveBuscarTextosNaPagina(){

//      getText para transformar em uma string
        //System.out.println(driver.findElement(By.tagName("body")).getText());
/*
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento",
                driver.findElement(By.tagName("h3")).getText());

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());
 */
        Assert.assertEquals("Campo de Treinamento",
                driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());
        driver.quit();
    }

}
