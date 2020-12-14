package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastrarProfessorPO {
	
	private static WebElement element = null;

	public static WebElement campoAdmin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		return element;
	}

	public static WebElement botaoProfessor(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[9]/a"));
		return element;
	}
	
	public static WebElement botaoCadastrar(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/button"));
		return element;
	}	
	
	public static WebElement campoSiape(WebDriver driver) {
		element = driver.findElement(By.id("siape"));
		return element;
	}
	public static WebElement campoNome(WebDriver driver) {
		element = driver.findElement(By.id("nome"));
		return element;
	}
	public static WebElement campoDataIngresso(WebDriver driver) {
		element = driver.findElement(By.id("dataIngresso"));
		return element;
	}
	public static WebElement campoDataNascimento(WebDriver driver) {
		element = driver.findElement(By.id("dataNasc"));
		return element;
	}
	public static WebElement campoRegime(WebDriver driver) {
		element = driver.findElement(By.id("regime"));
		return element;
	}
	public static WebElement campoCargaHoraria(WebDriver driver) {
		element = driver.findElement(By.id("cargaAtual"));
		return element;
	}
	public static WebElement campoLotacao(WebDriver driver) {
		element = driver.findElement(By.id("lotacao"));
		return element;
	}
	public static WebElement campoCNome(WebDriver driver) {
		element = driver.findElement(By.id("cnome"));
		return element;
	}
	public static WebElement campoStatus(WebDriver driver) {
		element = driver.findElement(By.id("statusProfessor"));
		return element;
	}
	public static WebElement botaoSalvar(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]"));
		return element;
	}
	public static WebElement campoPesquisa(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/input"));
		return element;
	}
	public static WebElement siapeGrid(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[1]"));
		return element;
	}
	public static WebElement nomeGrid(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[2]"));
		return element;
	}
	public static WebElement statusGrid(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[3]"));
		return element;
	}
	public static WebElement botaoExcluir(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/button[1]"));
		return element;
	}
	public static WebElement confirmarExclusao(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]"));
		return element;
	}
	public static WebElement nenhumRegistro(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr"));
		return element;
	}
}