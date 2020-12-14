package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

import org.junit.Assert;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.After;
import cucumber.api.Scenario;
import cucumber.api.DataTable;

import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPO;

public class LoginStep {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@Dado("^que o usuario tenha acesso a pagina inicial do Sistema de Distribuicao de Disciplinas$")
	public void queOUsuarioTenhaAcessoAPaginaInicialDoSistemaDeDistribuicaoDeDisciplinas() throws Throwable {
	    
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
		
	}

	@Quando("^entrar com seu \"([^\"]*)\"$")
	public void entrarComSeu(String siape) throws Throwable {
	    
		LoginPO.campoSiape(driver).click();
		LoginPO.campoSiape(driver).sendKeys(siape);
		LoginPO.botaoEntrar(driver).click();
		
	}

	@Entao("^o usuario sera logado com sucesso$")
	public void oUsuarioSeraLogadoComSucesso() throws Throwable {
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='semestre']")));
		
		System.out.println("\n *** Logado com sucesso! *** \n");
		
	}
	
	@After("@LoginStep")
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
