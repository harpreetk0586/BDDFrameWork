package com.git.qa.StepDefinitions;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import com.git.qa.base.TestBase;
import com.git.qa.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends TestBase {
	LoginPage lp = new LoginPage();

	public LoginStepDefinitions() throws IOException {
		super();

	}

	@Given("User on the signin page")
	public void user_on_the_signin_page() throws IOException {
		lp.getURL();
	}

	@Given("title of signin page is")
	public void title_of_signin_page_is() {

		Assert.assertEquals(prop.getProperty("loginpagetitle"), TestBase.driver.getTitle());
	}

	@When("user signs in with valid username and password")
	public void user_enters_valid_username_and_password(DataTable test) {
		List<List<String>> data = test.asLists();
		lp.signin(data.get(0).get(0), data.get(0).get(1));
	}

	@Then("user clicks userdropdown and confirms username")
	public void user_clicks_userdropdown_and_confirms_username(DataTable test1) {
		List<String> data1 = test1.asList();
		Assert.assertEquals(data1.get(0), lp.confirmSignin());
	}

	@Then("user clicks signout")
	public void user_clicks_signout() {
		lp.signOut();
		Assert.assertEquals(prop.getProperty("logoutpapetitle"), lp.getTitle());
	}

	@When("user signs in with wrongusername {string} and wrongpassword {string}")
	public void user_signs_in_with_wrongusername_and_wrongpassword(String username, String password) {
		lp.signin(username, password);
	}

	@Then("user should see alert message")
	public void user_should_see_alert_message() {

		Assert.assertEquals(prop.getProperty("signinErrMsg"), lp.getSiginAlertMsg());
	}
}
