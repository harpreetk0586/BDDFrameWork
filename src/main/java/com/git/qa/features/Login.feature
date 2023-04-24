#Author: Harpreet Kaur
#Keywords Summary : It tests the login functionality of the github.
Feature: Login
Background: 
Given User on the signin page
And title of signin page is 

Scenario: Testing SucessLoginLogout Functionality

When user signs in with valid username and password 
|harpreetk0586|XXXXXXXXX|
Then user clicks userdropdown and confirms username 
|harpreetk0586|
And user clicks signout


Scenario Outline: Testing sign in with wrong credentials 

When user signs in with wrongusername "<username>" and wrongpassword "<password>"
Then user should see alert message


Examples:
|username | password|
|vhjDJn,aJSDIC|H\DVHFGDB|