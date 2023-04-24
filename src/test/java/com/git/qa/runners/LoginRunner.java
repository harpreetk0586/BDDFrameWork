package com.git.qa.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)
	@CucumberOptions(
	   //path of feature file
	   features = "src/main/java/com/git/qa/features/Login.feature",
	   //path of step definition file
	   glue = "com/git/qa/StepDefinitions",
	   stepNotifications=true,
	   dryRun=false
	   )
	public class LoginRunner {
	}

