package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class ForgotPass {

	WebDriver driver = null;
	
	@Given("User is on Main Screen from PS Enterprise Gameshop Apps")
	public void User_is_on_main_screen_from_ps_enterprise_gameshop_apps() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.psegameshop.com/my-account/");
		driver.manage().window().maximize();
	}
	
	@When("User click Lost Your Password button")
	public void user_click_lost_your_password_button() {
		driver.findElement(By.linkText("Lost your password?")).click();
	}

	@Then("User is on Lost Password Page")
	public void user_is_on_lost_password_page() {
		driver.findElement(By.xpath("//p[contains(text(),'Lost your password?')]"));
	}

	@When("User fill the registered email")
	public void user_fill_the_registered_email() {
		driver.findElement(By.id("user_login")).sendKeys("testing1@goo.co");
	}
	
	@When("User click Reset Password button")
	public void user_click_reset_password_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Reset password')]")).click();
	}

	@Then("User get info 'Password reset email has been sent'")
	public void user_get_info() {
	    driver.findElement(By.className("icon-checkmark"));
	    driver.close();
	}
}
