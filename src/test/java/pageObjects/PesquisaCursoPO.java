package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaCursoPO {
	
	private static WebElement element = null;

	public static WebElement campoAdmin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		return element;
	}

	public static WebElement botaoCurso(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]"));
		return element;
	}
	
	public static WebElement campoPesquisaCurso(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/input"));
		return element;
	}
	
	public static WebElement campoCodigoGrid(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[1]"));
		return element;
	}
	
	public static WebElement campoNomeGrid(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[2]"));
		return element;
	}
	
}