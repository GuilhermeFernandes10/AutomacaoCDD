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

import pageObjects.CadastrarCursoPO;
import pageObjects.LoginPO;
import pageObjects.PesquisaCursoPO;

public class ListaCursoStep {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Dado("^que o usuario tenha acesso a tela de pesquisa de curso$")
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


	@Quando("^eu informar o nome de um \"([^\"]*)\"$")
	public void euInformarONomeDeUm(String curso) throws Throwable {
		PesquisaCursoPO.campoAdmin(driver).click();
		PesquisaCursoPO.botaoCurso(driver).click();
		
		Thread.sleep(1000);
		PesquisaCursoPO.campoPesquisaCurso(driver).click();
		PesquisaCursoPO.campoPesquisaCurso(driver).sendKeys(curso);

	}

	@Entao("^o sistema ira trazer o curso de acordo com o \"([^\"]*)\" da pesquisa$")
	public void oSistemaIraTrazerOCursoDeAcordoComODaPesquisa(String curso) throws Throwable {
		
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[2]"), "Gestão da Informação"));
	}

	@Quando("^eu informar na poesquisa o nome de um \"([^\"]*)\" completo$")
	public void euInformarNaPoesquisaONomeDeUmCompleto(String curso) throws Throwable {
		
		PesquisaCursoPO.campoAdmin(driver).click();
		PesquisaCursoPO.botaoCurso(driver).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div[1]/div/div")));
		PesquisaCursoPO.campoPesquisaCurso(driver).click();
		PesquisaCursoPO.campoPesquisaCurso(driver).sendKeys(curso);

	}

	@Entao("^o sistema apresentara os registros de acordo com o \"([^\"]*)\" informado na pesquisa$")
	public void oSistemaApresentaraOsRegistrosDeAcordoComOInformadoNaPesquisa(String curso) throws Throwable {
		
		Thread.sleep(1000);
		String resultadoPesquisa = PesquisaCursoPO.campoNomeGrid(driver).getText();
		Assert.assertEquals(resultadoPesquisa, "Engenharia de Alimentos (Patos de Minas)");
		
		System.out.println(resultadoPesquisa + "Engenharia de Alimentos (Patos de Minas)");

	}
	
	@After("@ListaCurso")
	public void screenshotValidarFilaProfSemTurma(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/Validar_Lista_Curso" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Fim");
	}
}