package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementOperation implements Element{
	
	private final WebDriver driver;
	
	private WebElement element;
	private TypeOperation operation;
	private String message;
	
	public WebElementOperation(WebDriver driver, By option, TypeOperation operation, String message) {
		this.driver = driver;
		this.element = this.driver.findElement(option);
		this.operation = operation;
		this.message = message;
	}
	
	public WebElementOperation(WebDriver driver, By option, TypeOperation operation, String message, int timewait) {
		this.driver = driver;
		if(timewait <= 0) {
			this.element = this.driver.findElement(option);
		}else {
			WebDriverWait wait = new WebDriverWait(this.driver, timewait);
			this.element = wait.until(ExpectedConditions.visibilityOfElementLocated(option));
		}
		this.operation = operation;
		this.message = message;
	}
	
	@Override
	public  void execute()  {
		switch (operation) {
		case CLICK:{
			this.element.click();
			break;
		}
		
		case SENDKEY:{
			if(this.message != null && this.message.compareTo("") != 0) {
				if(message.charAt(message.length() - 1) == '_') {
					this.element.sendKeys(message.substring(0, message.length() - 1).concat(" \n"));
				}else
					this.element.sendKeys(message);
			}else {
				throw new RuntimeException("Mensaje nulo o incorrecto");
			}
			break;
		}
		default:
			System.err.println("Operacion no valida");
			break;
		}
	}
	
}
