package test;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.CampoTreinamentoPage;

public class TesteCadastroPage3 extends BaseTest {

	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Ricardo");
		page.setSobrenome("Veiga");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		//System.out.println("fed");
		page.cadastrar();

		//Tem outra forma de validar usando XPATH
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Ricardo"));
		Assert.assertEquals("Sobrenome: Veiga", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
	}

}
