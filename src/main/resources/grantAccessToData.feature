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
Feature: Title of your feature
  I want to use this template for my feature file

@tag1
  Scenario: access existing data
  	Given A logistic company
    And a journey from "Copenhagen" to "Oslo" with 80 hours to destination
    And existing client
    And an owned container
 		And the container is put on the journey containing "bananas"
 		And journey is started and run for 10 hours
 		When client with container grants other client access to data of container
 		And other client tries to get history
 		Then access successfully granted
		And response message saying that history of container was successfully retrieved to client

@tag2
  Scenario: access existing data
  	Given A logistic company
    And a journey from "Copenhagen" to "Oslo" with 80 hours to destination
    And a client from another company
    And an owned container
 		And the container is put on the journey containing "bananas"
 		And journey is started and run for 10 hours
 		When client with container grants other client access to data of container
 		And other client tries to get history
 		Then error message displayed saying that they are not in same company


