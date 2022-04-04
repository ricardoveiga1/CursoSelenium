package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import javax.annotation.PostConstruct;

public class TesteGoogle {

    @Test
    public void teste() {
        //System.setProperty("webdriver.gecko.driver", "/Users/ricardoveiga/Drivers/geckodriver");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "/Users/ricardoveiga/Drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        //driver.manage().window().setPosition(new Point(100, 100));
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("http://www.google.com/");
        //System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();

    }
}
