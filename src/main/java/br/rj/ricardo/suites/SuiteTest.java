package br.rj.ricardo.suites;

import br.rj.ricardo.core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import br.rj.ricardo.test.TesteCadastroPage3;
import br.rj.ricardo.test.TesteRegrasCadastro;

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
