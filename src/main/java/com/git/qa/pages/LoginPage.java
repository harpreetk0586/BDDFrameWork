package com.git.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.git.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "login")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "commit")
	WebElement signinButton;
	@FindBy(xpath = "//details[@class='details-overlay details-reset js-feature-preview-indicator-container']//summary[@class='Header-link']")
	WebElement userDropDown;
	@FindBy(xpath = "//strong[@class='css-truncate-target']")
	WebElement homepageUser;
	@FindBy(xpath = "//*[contains(text(),'Sign out')]")
	WebElement signOut;
	@FindBy(xpath = "//*[contains(text(),'Incorrect username or password.')]")
	WebElement signinAlertMsg;

	public void getURL() throws IOException {
		driver.get(prop.getProperty("URL"));
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void signin(String name, String pwd) {

		username.sendKeys(name);
		password.sendKeys(pwd);
		signinButton.click();

	}

	public String confirmSignin() {

		userDropDown.click();
		return homepageUser.getText();

	}

	public void signOut() {
		driver.navigate().refresh();
		userDropDown.click();
		signOut.click();

	}

	public String getSiginAlertMsg() {

		return signinAlertMsg.getText();

	}

}
