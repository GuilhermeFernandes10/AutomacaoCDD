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
import pageObjects.FilaProfComTurmaPO;
import pageObjects.FilaProfSemTurmaPO;

public class FilaProfComTurmaStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario tenha acesso a tela inicial do sistema de disciplinas$")
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
	
	@Quando("^pesquisa pelo nome completo do \"([^\"]*)\"$")
	public void buscarPeloProfessorDigitandoONomeCompleto(String professor) throws Throwable {
	    
		Thread.sleep(1000);
		FilaProfComTurmaPO.exibirFilaProfComTurma(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[2]/div")));
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).click();
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).sendKeys(professor);
		FilaProfComTurmaPO.primeiroProfComTurma(driver).click();
		
	}

	@Entao("^o sistema retornara os resultados de acordo com o \"([^\"]*)\" informado$")
	public void oSistemaMostraraAFilaDoProfessorBuscadoComONomeCompleto(String professor) throws Throwable {
	    
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Rivalino Matias Jr."));
		
		System.out.println("\n ***** A pesquisa foi realizada com sucesso ! *****");
		
	}

	@Quando("^pesquisa pelo nome incompleto do \"([^\"]*)\"$")
	public void buscarPeloProfessorNaoDigitandoONomeCompleto(String professor) throws Throwable {
	    
		FilaProfComTurmaPO.exibirFilaProfComTurma(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[2]/div")));
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).click();
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfComTurmaPO.primeiroProfComTurma(driver).click();
		
	}

	@Entao("^o sistema retornara os resultado de acordo com o \"([^\"]*)\" informado no filtro$")
	public void oSistemaMostraraAFilaDoProfessorBuscadoComONomeIncompleto(String professor) throws Throwable {
	    
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Maria Adriana Vidigal de Lima"));
		
		System.out.println("\n ***** A pesquisa foi realizada com sucesso ! *****");
		
	}

	@Quando("^pesquisar por um \"([^\"]*)\" que possui fila$")
	public void buscarPeloProfessorQuePossuiFila(String professor) throws Throwable {
	    
		FilaProfComTurmaPO.exibirFilaProfComTurma(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[2]/div")));
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).click();
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfComTurmaPO.primeiroProfComTurma(driver).click();
		
	}

	@Entao("^o sistema retornara a fila com as disciplinas do \"([^\"]*)\"$")
	public void oSistemaMostraraAFilaDoProfessor(String professor) throws Throwable {
	    
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[3]/table/thead/tr[1]/th"), "Maria Adriana Vidigal de Lima"));
		
		System.out.println("\n ***** A pesquisa foi realizada com sucesso ! *****");
	}

	@Quando("^buscar pelo professor\"([^\"]*)\" que nao possui fila de disciplina$")
	public void buscarPeloProfessorQueNaoPossuiFila(String professor) throws Throwable {
	    
		FilaProfComTurmaPO.exibirFilaProfComTurma(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[2]/div")));
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).click();
		FilaProfComTurmaPO.campoPesquisaProfComTurma(driver).sendKeys(professor);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding ng-scope']")));
		FilaProfComTurmaPO.primeiroProfComTurma(driver).click();
		
	}

	@Entao("^o sistema nao exibira uma fila de disciplinas para o \"([^\"]*)\"$")
	public void oSistemaNaoMostraraAFilaDoProfessor(String professor) throws Throwable {
	    
		Thread.sleep(250);
		if (FilaProfComTurmaPO.validacaoPesquisaNomeProfComTurma(driver).isDisplayed()) {
			System.out.println("\nO professor possui fila!\n");
		}
		
		else {
			System.out.println("\nO professor não possui fila!\n");
		}
		
	}
	
	@After("@FilaProfComTurma")
	public void screenshotValidarFilaProfSemTurma(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/Validar_Fila_Prof_Com_Turma" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Fim");
	}

}
