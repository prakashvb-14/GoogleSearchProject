Feature: Search Functionality

  Background:
    Given user launches the website successfully


  @Sanity @Regression
  Scenario: To verify J.P.Morgon Logo is displayed
    Given I am an user who launch the search engine
    And I enter the 'J. P. Morgan' in search box
    When I click the first search result
    Then J.P.Morgon website should be launched
    And I should see the logo is displayed correctly

  @Sanity @Regression
  Scenario: To verify incorrect results is populated if the bank name is entered incorrectly
    Given I am an user who launch the search engine
    When I enter the 'Wikipedia' in search box
    When I click on the search results
    Then I should not see the correct page loaded with logo

  @Sanity @Regression
  Scenario: To verify incorrect page is displayed if the user selects any other results from the search
    Given I am an user who launch the search engine
    When I enter the 'J. P. Morgan' in search box
    And I should see results displayed
    When I click on the results which dont have J.P. Morgan
    Then I should not see the correct page loaded with logo