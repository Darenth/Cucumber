Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario: Login Successful

    Given I am in the login page of the Para Bank Application
    When  I enter valid credentials
    Then I should be taken to the Overview page


  Scenario Outline: Login Successful with parameters

    Given I am in the login page of the Para Bank Application
    When  I enter valid <username> and <password>
    Then I should be taken to the Overview page


    Examples:
      | username     | password   |  userFullName|
      | "autotester" | "password" | " Auto Tester" |
      |              |            |  |


  Scenario: Login Successful1

    Given I am in the login page of the Para Bank Application
    When  I enter valid credentials from Data Table
      | autotester | password | " Fg9Eorec yISecpwp" |
    Then I should be taken to the Overview page


  Scenario Outline: Login Successful with dependency injection

    Given I am in the login page of the Para Bank Application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the Overview page

    Examples:
      | username     | password   | userFullName   |
      | "autotester" | "password" | " Fg9Eorec yISecpwp" |
