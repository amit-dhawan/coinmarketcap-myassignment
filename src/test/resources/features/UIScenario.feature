@UITest
Feature: CoinMarket landing page feature

  @Frontend_Task1
  Scenario Outline: Verify correct rows are displayed on Landing page
    Given I am on the homepage
    When I get the title of the page
    Then page title should be "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap"
    Then I select "<rows>" from the showrows option
    And I validate "<rows>" rows are displayed

    Examples: 
      | rows |
      |  100 |

  @Frontend_Task2
  Scenario: Verify Filter results
    Given I am on the homepage
    When I get the title of the page
    Then page title should be "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap"
    And I open filter dialog
    And I select filter criteria
      | filtername | MinRange       | MaxRange        |
      | MarketCap  | $1,000,000,000 | $10,000,000,000 |
      | price      | $1             | $101            |
    And I validate filtering results are correct
