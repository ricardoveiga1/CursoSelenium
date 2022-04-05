package suites;

import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TesteCadastroPage3;
import test.TesteRegrasCadastro;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastroPage3.class,
        TesteRegrasCadastro.class,
})
public class SuiteTest {

    @AfterClass
    public static void finalizaTudo(){

        DriverFactory.killDriver();
    }
}
