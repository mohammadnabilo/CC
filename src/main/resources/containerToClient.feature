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
Feature: Allocate a container to a client

  @tag1
  Scenario: succesfull allocation
    Given a logistic company with a client
    And an unowned container
    When a container is allocated
    Then an allocation succes message is displayed

  @tag2
  Scenario: container already owned
    Given a logistic company with another client
    And an owned container
    When a logistic company tries to allocate container
    Then an allocation failure message is displayed

	@tag3
  Scenario: container does not exist
    Given a logistic company with a client
    And a container that does not exist
    When a logistic company tries to allocate container to client
    Then an allocation failure message is displayed saying container does not exist
    
  @tag4
  Scenario: client does not exist
    Given a logistic company with a non-registered client
    And an unowned container
    When a logistic company tries to allocate container
    Then an allocation failure message is displayed saying client does not exist
    
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
