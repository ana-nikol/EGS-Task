# first file

  Feature: login
    Scenario Outline: successful login
      Given user is not logged in
      When user enters "<username>" and "<password>"
      And clicks login button
      Then user is navigated to home page
      Examples:
        | username | password |
        | ANN      | pas1     |
        | Ana      | passs2   |
      Scenario: unsuccessful login
        When user enters username1 and password1
        And clicks login button
        Then user receives error message


