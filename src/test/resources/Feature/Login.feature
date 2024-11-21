Feature: login functionality


  @Ronit
  Scenario Outline: Login with valid credentials
    Given  user has navigated to login page
    When user enter valid email address "<Email1>" into email field
    And user has enter valid password "<Password1>" into password field
    And user click on login button
    Then user should get succesfully logged in
    Examples:
      | Email1     | Password1 |
      | validemail | vaildpass |

  @smoke1
  Scenario Outline: Login with invalid credentials
      Given  user has navigated to login page
      When user enter invalid email address "<Email2>" into email field
      And user has enter invalid password "<Password2>" into password field
      And user click on login button
      Then user should get error message
      Examples:
        | Email2       | Password2   |
        | invalidemail | invalidpass |