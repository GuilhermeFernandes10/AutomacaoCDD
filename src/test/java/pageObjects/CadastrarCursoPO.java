package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastrarCursoPO {
	
	private static WebElement element = null;

	public static WebElement campoAdmin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		return element;
	}

	public static WebElement botaoCurso(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
		return element;
	}
	
	public static WebElement botaoNovoCurso(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/button"));
		return element;
	}
	
	public static WebElement campoCodigo(WebDriver driver) {
		element = driver.findElement(By.id("codigo"));
		return element;
	}
	
	public static WebElement campoNome(WebDriver driver) {
		element = driver.findElement(By.id("nome"));
		return element;
	}
	
	public static WebElement campoUnidade(WebDriver driver) {
		element = driver.findElement(By.id("unidade"));
		return element;
	}
	
	public static WebElement campoCampus(WebDriver driver) {
		element = driver.findElement(By.id("campus"));
		return element;
	}
	
	public static WebElement botaoCancelar(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
		return element;
	}
	
	
}