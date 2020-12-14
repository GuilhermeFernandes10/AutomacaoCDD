package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AtribuirTurmaProfessorPO {
	
	private static WebElement element = null;

	public static WebElement campoAdmin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		return element;
	}

	public static WebElement botaoAtribuicao(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[7]/a"));
		return element;
	}
	
	public static WebElement campoAtribuirTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[1]/div[1]/h4/a/span"));
		return element;
	}	
	
	public static WebElement campoPesquisa(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[1]/div[2]/div/div/div[2]/div/div/div/input"));
		return element;
	}
	
	public static WebElement botaoAtribuirTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[3]/button"));
		return element;
	}
	
	public static WebElement campoTurma(WebDriver driver) {
		element = driver.findElement(By.name("turma"));
		return element;
	}
	
	public static WebElement selecaoTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div[2]/div/div/div/ul/li/a"));
		return element;
	}
	
	public static WebElement tituloModal(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]"));
		return element;
	}
	
	public static WebElement botaoCancelar(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
		return element;
	}
	
}