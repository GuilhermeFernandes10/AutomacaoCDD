package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilaPorTurmaPO {
	
	private static WebElement element = null;

	public static WebElement expandirFilaPorTurma(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[6]/div[1]/h4/a/span"));
		return element;
	}

	public static WebElement campoDisciplina(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/accordion/div/div[6]/div[2]/div/div/div[2]/div/input"));
		return element;
	}
	
	public static WebElement selecaoTurma(WebDriver driver) {
		element = driver.findElement(By.cssSelector("a[class='ng-binding ng-scope']"));
		return element;
	}
	
}