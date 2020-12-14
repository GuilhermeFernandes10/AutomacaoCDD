package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

import org.junit.Assert;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.After;
import cucumber.api.Scenario;
import cucumber.api.DataTable;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPO;
import pageObjects.CadastrarProfessorPO;

public class CadastrarProfessorStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario tenha acesso a pagina de admin e a de cadastro de professor$")
	public void queOUsuarioEstejaLogado() throws Throwable {
	    
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader("asserts/valores.json"));
		JSONObject jsonObject = (JSONObject) object;
		
		String chromeDriver = (String) jsonObject.get("chromeDriver");
		String paginaAutenticacao = (String) jsonObject.get("paginaAutenticacaoAdmin");
		
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.get(paginaAutenticacao);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 4);
		
	}
	
	@Quando("^eu informar os campos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void euInformarOsCampos(String siape, String nome, String ingresso, String nascimento, String regime, String cargahoraria, String lotacao, String Cnome) throws Throwable {

		CadastrarProfessorPO.campoAdmin(driver).click();
		CadastrarProfessorPO.botaoProfessor(driver).click();
		CadastrarProfessorPO.botaoCadastrar(driver).click();
		Thread.sleep(1500);
		CadastrarProfessorPO.campoSiape(driver).click();
		CadastrarProfessorPO.campoSiape(driver).sendKeys(siape);
		CadastrarProfessorPO.campoNome(driver).click();
		CadastrarProfessorPO.campoNome(driver).sendKeys(nome);
		CadastrarProfessorPO.campoDataIngresso(driver).click();
		CadastrarProfessorPO.campoDataIngresso(driver).sendKeys(ingresso);
		CadastrarProfessorPO.campoDataNascimento(driver).click();
		CadastrarProfessorPO.campoDataNascimento(driver).sendKeys(nascimento);
		CadastrarProfessorPO.campoRegime(driver).click();
		CadastrarProfessorPO.campoRegime(driver).sendKeys(regime);
		CadastrarProfessorPO.campoCargaHoraria(driver).click();
		CadastrarProfessorPO.campoCargaHoraria(driver).sendKeys(cargahoraria);
		CadastrarProfessorPO.campoLotacao(driver).click();
		CadastrarProfessorPO.campoLotacao(driver).sendKeys(lotacao);
		CadastrarProfessorPO.campoCNome(driver).click();
		CadastrarProfessorPO.campoCNome(driver).sendKeys(Cnome);
		CadastrarProfessorPO.campoStatus(driver).click();
		CadastrarProfessorPO.campoStatus(driver).sendKeys("Ativo");
		CadastrarProfessorPO.campoStatus(driver).click();
		Thread.sleep(1000);
		CadastrarProfessorPO.botaoSalvar(driver).click();
		Thread.sleep(1000);
		CadastrarProfessorPO.campoPesquisa(driver).click();
		CadastrarProfessorPO.campoPesquisa(driver).sendKeys(nome);
		
	}

	@Entao("^o sistema ira cadastrar um novo professor de acordo com o \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" informados$")
	public void oSistemaIraCadastrarUmNovoProfessorDeAcordoComOInformados(String siape, String nome, String ingresso, String nascimento, String regime, String cargahoraria, String lotacao, String Cnome) throws Throwable {

		String siapeGrid = CadastrarProfessorPO.siapeGrid(driver).getText();
		Assert.assertEquals(siapeGrid, siape);
		System.out.println(siapeGrid + " - " + siape);
		
		String nomeGrid = CadastrarProfessorPO.nomeGrid(driver).getText();
		Assert.assertEquals(nomeGrid, nome);
		System.out.println(nomeGrid + " - " + nome);
		
		String statusGrid = CadastrarProfessorPO.statusGrid(driver).getText();
		Assert.assertEquals(statusGrid, "Ativo");
		System.out.println(statusGrid + " - " + "Ativo");
	}
	
	@Quando("^pesquisa um professor pelo \"([^\"]*)\" e clicar no botao excluir$")
	public void pesquisaUmProfessorPeloEClicarNoBotaoExcluir(String nome) throws Throwable {
		
		CadastrarProfessorPO.campoAdmin(driver).click();
		CadastrarProfessorPO.botaoProfessor(driver).click();
		CadastrarProfessorPO.campoPesquisa(driver).click();
		CadastrarProfessorPO.campoPesquisa(driver).sendKeys(nome);
		CadastrarProfessorPO.botaoExcluir(driver).click();
		CadastrarProfessorPO.confirmarExclusao(driver).click();
		
		CadastrarProfessorPO.campoPesquisa(driver).click();
		CadastrarProfessorPO.campoPesquisa(driver).sendKeys(nome);
		
		String nenhumRegistro = CadastrarProfessorPO.nenhumRegistro(driver).getText();
		
		Assert.assertEquals(nenhumRegistro, "Nenhum registro encontrado");
		System.out.println("Registro excluído com sucesso !! ");
	}

	@Entao("^o professor que foi pesquisado pelo \"([^\"]*)\" sera excluido$")
	public void oProfessorQueFoiPesquisadoPeloSeraExcluido(String nome) throws Throwable {

	}
	@After("@CadastrarProfessor")
	public void screenshotValidarCadastroCurso(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/Validar_Cadastro_Curso" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Fim");
	}
}