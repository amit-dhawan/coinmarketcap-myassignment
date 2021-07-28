@APITest
Feature: Back-end Testcases

  @APITest1
  Scenario Outline: PriceCoversion API Validation
    When I fetch ID for the currency "<currency_symbol>"
    Then I convert "<currency_symbol>" to "<convertToCurrency>" for "<amount>"

    Examples: 
      | currency_symbol | convertToCurrency | amount |
      | BTC             | BOLI              |    500 |

  @APITest2
  Scenario: Info API vaidation
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
  Scenario Outline: Info API validation with response and tag
    When I fetch the Technical documentation Website for currency id "<currencyID>"
    Then I validate response and mineable tag is associated with currency id "<currencyID>"

    Examples: 
      | currencyID |
      |          1 |
      |          2 |
      |          3 |
      |          4 |
      |          5 |
      |          6 |
      |          7 |
      |          8 |
      |          9 |
