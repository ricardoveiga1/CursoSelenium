package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TesteCadastroPage3;
import test.TesteCampoTreinamento1;
import test.TesteRegrasCadastro;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastroPage3.class,
        TesteRegrasCadastro.class,
})
public class SuiteTest {
}
