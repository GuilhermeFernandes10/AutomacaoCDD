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
import pageObjects.FilaProfSemTurmaPO;

public class FilaProfSemTurmaStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario esteja logado$")
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
	
	@Quando("^buscar pelo professor\"([^\"]*)\" digitando o nome completo$")
	public void buscarPeloProfessorDigitandoONomeCompleto(String professor) throws Throwable {
	    
		Thread.sleep(5000);
		FilaProfSemTurmaPO.exibirFilaProfST(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[2]/div/input")));
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).click();
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).sendKeys(professor);
		
	}

	@SuppressWarnings("deprecation")
	@Entao("^o sistema mostrara a fila do professor\"([^\"]*)\" buscado com o nome completo$")
	public void oSistemaMostraraAFilaDoProfessorBuscadoComONomeCompleto(String professor) throws Throwable {
	    
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Alessandra Aparecida Paulino"));
		
	}

	@Quando("^buscar pelo professor\"([^\"]*)\" nao digitando o nome completo$")
	public void buscarPeloProfessorNaoDigitandoONomeCompleto(String professor) throws Throwable {
	    
		FilaProfSemTurmaPO.exibirFilaProfST(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[2]/div/input")));
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).click();
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfSemTurmaPO.primeiroProfST(driver).click();
		
	}

	@SuppressWarnings("deprecation")
	@Entao("^o sistema mostrara a fila do professor\"([^\"]*)\" buscado com o nome incompleto$")
	public void oSistemaMostraraAFilaDoProfessorBuscadoComONomeIncompleto(String professor) throws Throwable {
	    
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Bruno Augusto Nassif Travençolo"));
		
	}

	@Quando("^buscar pelo professor\"([^\"]*)\" que possui fila$")
	public void buscarPeloProfessorQuePossuiFila(String professor) throws Throwable {
	    
		FilaProfSemTurmaPO.exibirFilaProfST(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[2]/div/input")));
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).click();
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfSemTurmaPO.primeiroProfST(driver).click();
		
	}

	@SuppressWarnings("deprecation")
	@Entao("^o sistema mostrara a fila do professor\"([^\"]*)\"$")
	public void oSistemaMostraraAFilaDoProfessor(String professor) throws Throwable {
	    
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Bruno Augusto Nassif Travençolo"));
		
	}

	@Quando("^buscar pelo professor\"([^\"]*)\" que nao possui fila$")
	public void buscarPeloProfessorQueNaoPossuiFila(String professor) throws Throwable {
	    
		FilaProfSemTurmaPO.exibirFilaProfST(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[2]/div/input")));
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).click();
		FilaProfSemTurmaPO.campoPesquisaProfST(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfSemTurmaPO.primeiroProfST(driver).click();
		
	}

	@Entao("^o sistema nao mostrara a fila do professor\"([^\"]*)\"$")
	public void oSistemaNaoMostraraAFilaDoProfessor(String professor) throws Throwable {
	    
		Thread.sleep(250);
		if (FilaProfSemTurmaPO.validacaoPesquisaNomeProfST(driver).isDisplayed()) {
			System.out.println("\nO professor possui fila!\n");
		}
		
		else {
			System.out.println("\nO professor não possui fila!\n");
		}
		
	}
	
	@After("@FilaProfSemTurma")
	public void screenshotValidarFilaProfSemTurma(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/Validar_Fila_Prof_Sem_Turma" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Fim");
	}

}
