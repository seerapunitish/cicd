
Feature: Purchase the Order in Ecommerce Website
  I want to use this template for my feature file

Background:
Given User Login on Landing Page.

  @Regression
  Scenario Outline: Checking the Positive Scenario
    Given User login with <Username> and <Password>
    When I added <productname> to Cart
    And checkout <productname> and submit the Order
    Then "THANKYOU FOR THE ORDER." message should be Displayed on Confirmation Page

    Examples: 
      | Username                             | Password            | productname |
      | Nitishreddyseerapu@gmail.com         |     Npr@0611        | ZARA COAT 3 |
      | register1@gmail.com                  |     Ammu@0611       |ZARA COAT 3  |
