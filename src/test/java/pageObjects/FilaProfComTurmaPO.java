package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilaProfComTurmaPO {
	
	private static WebElement element = null;

	public static WebElement exibirFilaProfComTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[7]/div[1]/h4/a/span"));
		return element;
	}
	
	public static WebElement campoPesquisaProfComTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"repeatSelect\"]"));
		return element;
	}
	
	public static WebElement primeiroProfComTurma(WebDriver driver) {
		element = driver.findElement(By.cssSelector("a[class='ng-binding ng-scope']"));
		return element;
	}
	
	public static WebElement validacaoPesquisaNomeProfComTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[7]/div[2]/div/div/div[3]/table/thead/tr[1]/th"));
		return element;
	}

}