import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastroPage.class,
        TesteRegrasCadastro.class,
        TesteCampoTreinamento.class
})
public class SuiteTest {
}
