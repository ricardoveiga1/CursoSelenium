package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {

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
    public void deveInteragirComALertSimples(){
        driver.findElement(By.id("alert")).click();

        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComALertConfirm(){

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Confirm Simples", texto); //alert.getText()
        alert.accept();
        String textoConfirm = alert.getText();
        Assert.assertEquals("Confirmado", textoConfirm); //alert.getText()
        alert.accept();

        driver.findElement(By.id("confirm")).click();
        alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.dismiss();

    }


    @Test
    public void deveInteragirComALertPrompt(){

        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();

    }

}
