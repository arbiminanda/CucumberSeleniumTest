package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LoginFacebook {
	
	WebDriver driver = null;
	Robot robot = null;
	
	@Given("User is on Main Screen from PS Enterprise Gameshop App")
	public void user_is_on_main_screen_from_ps_enterprise_gameshop_app() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.psegameshop.com/my-account/");
		driver.manage().window().maximize();
	}

	@When("User click Login With Facebook button")
	public void user_click_with_facebook_button() throws AWTException {
		driver.get(driver.findElement(By.xpath("//a[@data-provider='facebook']")).getAttribute("href"));
		robot = new Robot();
		robot.delay(2000);
	}
	
	@Then("User is on facebook login page")
	public void user_is_on_facebook_login_page() {
		driver.findElement(By.xpath("//span[contains(text(),'Facebook')]"));
	}

	@When("User fill the email from facebook account")
	public void user_fill_the_email_from_facebook_account() {
		driver.findElement(By.id("email")).sendKeys("testing1@goo.co");
	}

	@When("User fill the correct password")
	public void user_fill_the_correct_password() {
		driver.findElement(By.id("pass")).sendKeys("dgajhhjs2372");
	}
	
	@When("User click on Facebook Log In Button")
	public void user_click_on_facebook_log_in_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("User is on My Account Detail Page")
	public void user_is_on_my_account_detail_page() {
		driver.findElement(By.linkText("Account details"));
		driver.close();
	}
}
