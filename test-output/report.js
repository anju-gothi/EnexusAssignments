$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/AutoamteDropDown/dropdown.feature");
formatter.feature({
  "line": 1,
  "name": "DropDown feature",
  "description": "",
  "id": "dropdown-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "validate dropdown",
  "description": "",
  "id": "dropdown-feature;validate-dropdown",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Headless"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "set the browser in headless mode",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User is sending request  \"https://www.xe.com/\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User select one option from dropdown",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "option successfully get selected",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.set_the_browser_in_headless_mode()"
});
formatter.result({
  "duration": 7380989000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.xe.com/",
      "offset": 26
    }
  ],
  "location": "StepDefinition.user_is_sending_request(String)"
});
formatter.result({
  "duration": 6873691200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_select_one_option_from_dropdown()"
});
formatter.result({
  "duration": 12712313300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.option_successfully_get_selected()"
});
formatter.result({
  "duration": 48238200,
  "status": "passed"
});
});