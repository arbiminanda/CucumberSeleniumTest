package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LoginGoogleSteps {
	
	WebDriver driver = null;
	Robot robot = null;
	
	@Given("User is on Log In and Sign Up Page from PS Enterprise Gameshop App")
	public void user_is_on_log_in_and_sign_up_page_from_ps_enterprise_gameshop_app() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.psegameshop.com/my-account/");
		driver.manage().window().maximize();
	}
	
	@When("User click Login With Google button")
	public void user_click_login_with_google_button() throws AWTException {
		driver.get(driver.findElement(By.className("google-plus")).getAttribute("href"));
		robot = new Robot();
		robot.delay(1000);
	}

	@Then("User is on Google Email Log In page")
	public void user_is_on_google_email_log_in_page() {
		driver.findElement(By.xpath("//div[contains(text(),'Google')]"));
	}

	@When("^User fill a valid and registered google (.*)$")
	public void user_fill_a_valid_and_registered_google_email(String email) {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
	}

	@When("User click Next button")
	public void user_click_next_button() throws AWTException {
		driver.findElement(By.xpath("//span[contains(text(),'Berikutnya')]")).click();
		robot.delay(2000);
	}
	
	@Then("User is on Google Password Log In Page")
	public void user_is_on_google_password_log_in_page() {
		driver.findElement(By.xpath("//div[contains(text(),'Tampilkan sandi')]"));
	}
	
	@When("^User fill a correct (.*)$")
	public void user_fill_a_correct_password(String password) {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	}
	
	@Then("User is on Detail My Account Page from Apps")
	public void user_is_on_my_account_page_from_apps() {
		driver.findElement(By.xpath("//a[contains(text(),'Account details')]"));
		driver.close();
	}
}
