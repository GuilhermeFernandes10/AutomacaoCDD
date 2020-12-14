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
import pageObjects.AtribuirTurmaProfessorPO;

public class AtribuirTurmaProfessorStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario tenha acesso a tela de atribuicao de disciplina$")
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
	
	@Quando("^eu informar os campos de \"([^\"]*)\", \"([^\"]*)\"$")
	public void euInformarOsCamposDe(String nome, String turma) throws Throwable {
		
		AtribuirTurmaProfessorPO.campoAdmin(driver).click();
		AtribuirTurmaProfessorPO.botaoAtribuicao(driver).click();
		AtribuirTurmaProfessorPO.campoAtribuirTurma(driver).click();
		AtribuirTurmaProfessorPO.campoPesquisa(driver).click();
		AtribuirTurmaProfessorPO.campoPesquisa(driver).sendKeys(nome);
		AtribuirTurmaProfessorPO.botaoAtribuirTurma(driver).click();
		AtribuirTurmaProfessorPO.campoTurma(driver).click();
		AtribuirTurmaProfessorPO.campoTurma(driver).sendKeys(turma);
		AtribuirTurmaProfessorPO.selecaoTurma(driver).click();	
		AtribuirTurmaProfessorPO.botaoCancelar(driver).click();

	}
	
	@Entao("^o sistema ira atribuir a turma de acordo com o \"([^\"]*)\", \"([^\"]*)\"$")
	public void oSistemaIraAtribuirATurmaDeAcordoComO(String nome, String turma) throws Throwable {
		
		if(AtribuirTurmaProfessorPO.tituloModal(driver).isDisplayed())
		{
			System.out.println("Ocorreu um problema ao salvar");
			
		}
		else
		{
			System.out.println("O registro foi salvo com sucesso");
		}

	}
	

	@After("@AtribuirTurmaProfessor")
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