# first file

Feature: getUsers
  Scenario Outline: successful login
    Given user is not logged in
    When user enters "<username>" and "<password>"
    And clicks login button
    Then user is navigated to home page
    Examples:
      | username | password |
      | ANN    | pas1     |
      | ANA   | passs2   |
  Scenario: getUsers
    When get users
    And clicks login button
    Then user receives error message


