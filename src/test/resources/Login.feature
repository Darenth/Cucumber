Feature: Login Funtionality
  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully


Scenario: Login Successful

Given I am in the login page of the Para Bank Application
  When  I enter valid credentials
  Then I should be taken to the Overview page