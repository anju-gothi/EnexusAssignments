Feature:DropDown feature


  @Headless
  Scenario: validate dropdown
    Given set the browser in headless mode
    When User is sending request  "https://www.xe.com/"
    Then User select one option from dropdown
    Then option successfully get selected

    @nonHeadless
    Scenario: validate dropdown
      Given set the browser
      When User is sending request  "https://www.xe.com/"
      Then User select one option from dropdown
      Then option successfully get selected