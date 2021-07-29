@APITest
Feature: Back-end Testcases

  @APITest1
  Scenario Outline: PriceCoversion API Validation
    When I fetch ID for the currency "<baseCurrency>"
    Then I convert "<baseCurrency>" to "<convertToCurrency>" for "<amount>"

    Examples: 
      | baseCurrency | convertToCurrency | amount |
      | BTC          | BOLI              |      1 |
      | USDT         | BOLI              |      1 |
      | ETH          | BOLI              |      1 |


  @APITest2
  Scenario:  API technical documentation info validation
    When I fetch the Technical documentation Website for currency id "1027"
    Then I should see the following fields for currency id "1027"
      | fields        | values                                                       |
      | logo          | https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png |
      | technical_doc | https://github.com/ethereum/wiki/wiki/White-Paper            |
      | symbol        | ETH                                                          |
      | date_added    | 2015-08-07T00:00:00.000Z                                     |
      | platform      | null                                                         |
      | tags          | mineable                                                     |


  @APITest3
  Scenario Outline: Verify mineable tag for the curriencies
    When I fetch the curriencies by "<id>"
    Then I validate response and mineable tag is associated with currency id "<id>"

    Examples: 
      | id |
      |  1 |
      |  2 |
      |  3 |
      |  4 |
      |  5 |
      |  6 |
      |  7 |
      |  8 |
      |  9 |
      | 10 |
