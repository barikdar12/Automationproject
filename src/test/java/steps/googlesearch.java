package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

 

public class googlesearch {
	
	WebDriver driver;
	
	@Given("I am on the google homepage")
	public void i_am_on_the_google_homepage() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
	    }

	@When("I enter search {string}")
	public void i_enter_search(String string) {
//		driver.findElement("//input[@class='gLFyf']");
		
		WebElement searchBox;
		searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
		searchBox.sendKeys(string);
		
		   
	}

	@When("I click on goole search button")
	public void i_click_on_goole_search_button() {
		WebElement searchBtn;
		searchBtn = driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]"));
		searchBtn.click();
	    
	   
	}

	@Then("I recive related search result")
	public void i_recive_related_search_result() { 
	
	WebElement resultStats;
	resultStats = driver.findElement(By.xpath("//div[@id='result-stats']"));
	String results = resultStats.getText();
	
	System.out.println(resultStats);    
	   
	}

}
