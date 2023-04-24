#Author: Harpreet Kaur
#Keywords Summary :Testing the repo creation function using create and new buttons, user github repository should be empty for first 
#scenario to pass
Feature: Checking Repository creation function

Background: 
Given User on the signin page
And title of signin page is 
When user signs in with valid username and password 
|harpreetk0586|Hello7896!|
Then Create repository link or new link is present


@repo
Scenario: Creating first Repo 

When user clicks create repository 
Then user is on create a new repo page
When user enter repository name
And clicks create repository button
Then user is in created repository page
And user clicks signout


@repo
Scenario: Creating new Repo with different name

When user clicks new
Then user is on create a new repo page
When user enter a diffferent repository name
And clicks create repository button
Then user is in new repository page
And user clicks signout


@repo
Scenario: Creating new Repo with existing name 

When user clicks new
Then user is on create a new repo page
When user enter an existing repository name
Then user sees a popup error message
And user clicks signout