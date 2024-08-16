

 Feature: Error Validation
  Scenario Outline: Negative Scenario
    Given User Login on Landing Page.
    And User login with <Username> and <Password>
    Then "Incorrect email or password." is Displayed

  Examples: 
      | Username                             | Password            | productname |
      | Nitishreddyseerapu@gmail.com         |     Npr@061       | ZARA COAT 3 |
      | register1@gmail.com                  |     Ammu@061       |ZARA COAT 3  |