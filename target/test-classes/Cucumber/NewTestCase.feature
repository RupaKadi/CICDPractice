
@tag
Feature: Purchasee order from Ecommerce
  I want to use this template for my feature file
  
  Background:
  Given I logged in Ecommerce page

  @tag1
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to cart
    And checkout <productname> and <countryname> submit the order
    Then "Thankyou for the order." confirmation msg is displayed in Confirmation page


    Examples: 
      | name                      | password    |  productname   | countryname  |
      | roopapadmasri@gmail.com   | Hayaan123&  |  IPHONE 13 PRO | India        |
