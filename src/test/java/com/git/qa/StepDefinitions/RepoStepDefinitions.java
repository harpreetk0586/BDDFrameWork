package com.git.qa.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.git.qa.base.TestBase;
import com.git.qa.pages.RepoPage;
import com.git.qa.utilties.TestUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RepoStepDefinitions extends  TestBase{
	TestUtil tu=new TestUtil();
	RepoPage rp=new RepoPage();
	public final String reponame1="RepoTest1";

	public RepoStepDefinitions() throws IOException
	{
		super();
	}

	@Then("Create repository link or new link is present")
	public void create_repository_link_or_new_link_is_present() {

		Assert.assertTrue(rp.newRepoElements.size()>0 || rp.repoElements.size()>0);

	}
	@When("user clicks create repository")
	public void user_clicks_create_repository() {

		rp.create1stRepoClick();

	}
	@Then("user is on create a new repo page")
	public void user_is_on_create_a_new_repo_page() {
		Assert.assertEquals(rp.getTitle(), "Create a New Repository");
	}
	@When("user enter repository name")
	public void user_enter_repository_name() {
		rp.enterRepoName(reponame1);
		Assert.assertEquals(reponame1+" is available.",rp.getSuccessMsg());
	}
	@When("clicks create repository button")
	public void clicks_create_repository_button() {

		rp.createRepoButtonClick();
	}
	@Then("user is in created repository page")
	public void user_is_in_created_repository_page() {

		rp.assertRepoTitle(prop.getProperty("username")+"/"+reponame1);
	}


	@When("user clicks new")
	public void user_clicks_new() {
		rp.newRepoClick();
	}
	@When("user enter a diffferent repository name")
	public void user_enter_a_diffferent_repository_name() {
		rp.enterRepoName(tu.newRepoName);
		Assert.assertEquals(tu.newRepoName+" is available.",rp.getSuccessMsg());
	}

	@Then("user is in new repository page")
	public void user_is_in_new_repository_page() {
		rp.assertRepoTitle(tu.newRepoURL);
	}
	@When("user enter an existing repository name")
	public void user_enter_an_existing_repository_name() throws InterruptedException {
		rp.enterRepoName(reponame1);
        Thread.sleep(2000);
	}

	@Then("user sees a popup error message")
	public void user_sees_a_popup_error_message() {

		Assert.assertEquals("The repository RepoTest already exists on this account.", rp.getErrMsg());
	}
}