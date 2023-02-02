Feature: google search

Scenario Outline: simple search

Given I am on the google homepage
When I enter search "<term>"
And I click on goole search button
Then I recive related search result


  Examples: 
      | term              |
      | Quality assurance |
      | software Testing  |    
