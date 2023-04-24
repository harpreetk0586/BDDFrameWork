package com.git.qa.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.git.qa.base.TestBase;

public class RepoPage extends TestBase {

	public RepoPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Create repository")
	WebElement createRepo;
	@FindBy(linkText = "Create repository")
	public List<WebElement> repoElements;
	@FindBy(linkText = "New")
	WebElement newRepo;
	@FindBy(linkText = "New")
	public List<WebElement> newRepoElements;
	@FindBy(id = "repository_name")
	WebElement enterRepoName;
	@FindBy(className = "success")
	WebElement successMsg;
	// @FindBy(className = "error")
	@FindBy(xpath = "//*[contains(text(),'already exists on this account')]")
	WebElement errMsg;
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	WebElement createRepoButton;

	public void create1stRepoClick() {

		createRepo.click();

	}

	public String getTitle() {

		return driver.getTitle();
	}

	public void enterRepoName(String name) {
		enterRepoName.sendKeys(name);

	}

	public String getSuccessMsg() {
		return successMsg.getText();

	}

	public void createRepoButtonClick() {
		createRepoButton.click();

	}

	public void newRepoClick() {

		newRepo.click();

	}

	public String getErrMsg() {

		return errMsg.getText();

	}

	public void assertRepoTitle(String name) {
		Assert.assertEquals(name, driver.getTitle());
	}

}
