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
import pageObjects.FilaPorTurmaPO;

public class FilaPorTurmaStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario tenha acesso a pesquisa de filas por turma$")
	public void queOUsuarioEstejaLogado() throws Throwable {
	    
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader("asserts/valores.json"));
		JSONObject jsonObject = (JSONObject) object;
		
		String chromeDriver = (String) jsonObject.get("chromeDriver");
		String paginaAutenticacao = (String) jsonObject.get("paginaAutenticacao");
		
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.get(paginaAutenticacao);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 4);
		
		String siape = (String) jsonObject.get("siape");
		
		LoginPO.campoSiape(driver).click();
		LoginPO.campoSiape(driver).sendKeys(siape);
		LoginPO.botaoEntrar(driver).click();
		
	}
	
	@Quando("^buscar pelo nome da \"([^\"]*)\" os professores na fila$")
	public void buscarPeloNomeDaOsProfessoresNaFila(String turma) throws Throwable {
		
		Thread.sleep(1000);
		FilaPorTurmaPO.expandirFilaPorTurma(driver).click();
		FilaPorTurmaPO.campoDisciplina(driver).click();
		FilaPorTurmaPO.campoDisciplina(driver).sendKeys(turma);
		FilaPorTurmaPO.selecaoTurma(driver).click();

	}

	@Entao("^o sistema apresentara os professores na lista da \"([^\"]*)\" de acordo com os dados informados$")
	public void oSistemaApresentaraOsProfessoresNaListaDaDeAcordoComOsDadosInformados(String arg1) throws Throwable {

	}
	
	@After("@FilaPorTurma")
	public void screenshotLogin(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/login/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Fim");
	}
}