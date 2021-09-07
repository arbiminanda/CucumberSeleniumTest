package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
	
	WebDriver driver = null;
	    
	@Given("User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps")
	public void user_is_on_log_in_and_sign_up_page_from_ps_enterprise_gameshop_apps() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.psegameshop.com/my-account/");
		driver.manage().window().maximize();
	}

	@When("User click on Remember Me checklist box button")
	public void user_click_on_remember_me_checklist_box_button() {
		driver.findElement(By.id("rememberme")).click();
	}
	
	@When("^User fill the registered and verified (.*) on the login email field$")
	public void user_fill_the_registered_email_on_the_login_email_field(String email) {
		driver.findElement(By.id("username")).sendKeys(email);
	}

	@When("^User fill the correct (.*) on the login password field$")
	public void user_fill_the_correct_password_on_the_login_password_field(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User click on Log In Button")
	public void user_click_on_log_in_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("User is on My Account Page from Apps")
	public void user_is_on_my_account_page_from_apps() {
		driver.findElement(By.xpath("//a[contains(text(),'Account details')]"));
		driver.close();
	}
}