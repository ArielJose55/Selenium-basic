package core;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Allitebook {

	private WebDriver driver;
	private final String pathDriver;
	
	public Allitebook() {
		this.pathDriver = "chromedriver.exe";
		loadDriver();
		this.driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	private void loadDriver() {
		System.setProperty("webdriver.chrome.driver", this.pathDriver);
	}
	
	public void config(String page, int time, TimeUnit unity) {
		this.driver.manage().window().maximize();
		this.driver.get(page);
		this.driver.manage().timeouts().implicitlyWait(time, unity);
	}
	
	/*
	public void run(Queue<Element> listOfOperation) {
		try {
			do {
				Element element = listOfOperation.poll();
				if(element == null)
					break;
				element.execute();
			}while(true);
		}catch (RuntimeException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
	*/
	public void close() {
		this.driver.close();
	}
}
