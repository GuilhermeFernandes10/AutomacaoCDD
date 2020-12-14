package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {
	
	private static WebElement element = null;

	public static WebElement campoSiape(WebDriver driver) {
		element = driver.findElement(By.cssSelector("input[name='siape']"));
		return element;
	}

	public static WebElement botaoEntrar(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/fieldset/button"));
		return element;
	}
	
	public static WebElement validacaoLogin(WebDriver driver) {
		element = driver.findElement(By.name("select[name='semestre']"));
		return element;
	}
	
}
