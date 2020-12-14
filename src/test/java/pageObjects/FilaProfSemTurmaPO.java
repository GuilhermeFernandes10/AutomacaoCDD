package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilaProfSemTurmaPO {
	
	private static WebElement element = null;

	public static WebElement exibirFilaProfST(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[5]/div[1]/h4/a/span"));
		return element;
	}
	
	public static WebElement campoPesquisaProfST(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[2]/div/input"));
		return element;
	}
	
	public static WebElement primeiroProfST(WebDriver driver) {
		element = driver.findElement(By.cssSelector("a[class='ng-binding ng-scope']"));
		return element;
	}
	
	public static WebElement validacaoPesquisaNomeProfST(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[5]/div[2]/div/div/div[3]/table/thead/tr[1]/th"));
		return element;
	}

}
