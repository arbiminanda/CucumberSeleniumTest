package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class RegistSteps {

	WebDriver driver = null;
	Robot robot = null;
	
	@Given("New User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps")
	public void new_user_is_on_log_in_and_sign_up_page_from_ps_enterprise_gameshop_apps() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.psegameshop.com/my-account/");
		driver.manage().window().maximize();
	}
	
	@When("User choose one of Favorite Genre from dropdown list")
	public void user_choose_one_of_favorite_genre_from_dropdown_list() {
		driver.findElement(By.xpath("(//select[@class='input-text'])[1]")).click();
	    driver.findElement(By.xpath("//option[@value='Action']")).click();
	}

	@When("User choose one of Favorite Console from dropdown list")
	public void user_choose_one_of_favorite_console_from_dropdown_list() {
		driver.findElement(By.xpath("(//select[@class='input-text'])[2]")).click();
		driver.findElement(By.xpath("//option[@value='Playstation']")).click();
	}

	@When("User choose one of Hobbies & Interests from dropdown list")
	public void user_choose_one_of_hobbies_interests_from_dropdown_list() {
		driver.findElement(By.xpath("(//select[@class='input-text'])[3]")).click();
		driver.findElement(By.xpath("//option[@value='Culinary']")).click();
	}

	@When("User choose one of Gender from two radiobuttons")
	public void user_choose_one_of_gender_from_two_radiobuttons() {
	    driver.findElement(By.xpath("//input[@value='Male']")).click();
	}

	@When("^User fill a valid (.*) address$")
	public void user_fill_a_valid_email_address(String new_email) {
	    driver.findElement(By.id("reg_email")).sendKeys(new_email);
	}
	
	@When("^User fill a valid (.*) that contain at least nine characters$")
	public void user_fill_a_valid_password_that_contain_at_least_nine_characters(String password) {
		driver.findElement(By.id("reg_password")).sendKeys(password);
	}

	@When("^User fill the same (.*) in confirm password field$")
	public void user_fill_the_same_password_in_confirm_password_field(String password) {
		driver.findElement(By.id("reg_confirm_password")).sendKeys(password);
	}

	@When("User click the Register button")
	public void user_click_the_register_button() throws AWTException {
		driver.findElement(By.xpath("//button[contains(text(),\"Register\")]")).click();
		robot = new Robot();
		robot.delay(1500);
	}
	
	@Then("User get info 'Thank you for registering. Your account has to be activated before you can login. Please check your email.'")
	public void user_get_info() {
		driver.findElement(By.xpath("//i[@class='icon-checkmark']"));
		driver.close();
	}
	
	@Then("User get error message 'Error: An account is already registered with your email address.'")
	public void user_get_error() {
	    driver.findElement(By.xpath("//strong[contains(text(),'Error:')]"));
	    driver.close();
	}
}
