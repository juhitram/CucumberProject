#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Values page test
 Description: In values page check the right count of values, currency and total balance

  Background: 
		Given user is able to open the url
    When user can see the Values Page

  @smoketest
  Scenario: check right count of values on the values page
    Then verify the right count of values appear on the screen
    And close the browser
    
    @regressiontest
  Scenario: check values on the screen greater than zero
    Then verify the values on the screen are greater than zero
    And close the browser
    
   @regressiontest
  Scenario: check the total balance is currect
    Then verify the total balance is correct based on the values listed on the screen
    And close the browser
    
   @regressiontest
  Scenario: check the values are formatted as currencies
    Then verify the values are formatted as currencies
    And close the browser