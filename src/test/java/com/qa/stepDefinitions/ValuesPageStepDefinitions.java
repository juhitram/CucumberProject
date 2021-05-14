package com.qa.stepDefinitions;

import com.qa.pages.ValuesPage;
import com.qa.utill.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ValuesPageStepDefinitions extends TestBase  {
	ValuesPage page = new ValuesPage();
	// Cucumber Hooks to launch browser before each scenario
	@Before
	public void launchBrowser() {
		System.out.println("to launch chrome driver");
		TestBase.initialization();	
	}
	// Cucumber Hooks to lauch browser after each scenario
	@After
	public void closeBrowser() {
		System.out.println("to launch chrome driver");
		driver.quit();
	}
	
	@Given("^user is able to open the url$")
	public void user_is_able_to_open_the_url() throws Throwable {
		//TestBase.initialization();
	}

	@When("^user can see the Values Page$")
	public void user_can_see_the_Values_Page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "value");
	    
	}

	@Then("^verify the right count of values appear on the screen$")
	public void verify_the_right_count_of_values_appear_on_the_screen() throws Throwable {
		int values = page.getRightCountOfValues();
		Assert.assertEquals(5, values);
	    
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		TestBase.teardown();   
	}

	@Then("^verify the values on the screen are greater than zero$")
	public void verify_the_values_on_the_screen_are_greater_than_zero() throws Throwable {
		Assert.assertTrue(page.verifyAmountGreaterThanZero());
		
	   }

	@Then("^verify the total balance is correct based on the values listed on the screen$")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() throws Throwable {
		Assert.assertTrue(page.verifyTotalBalance());
	    }

	@Then("^verify the values are formatted as currencies$")
	public void verify_the_values_are_formatted_as_currencies() throws Throwable {
		Assert.assertTrue(page.verifyCurrencyOfValue());
	   }
	



}
