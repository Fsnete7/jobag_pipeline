Feature: As a Postulant I want to see my interviews

  Scenario Outline: As a postulant i want to access to my active payment plans
    Given I am in the interview section
    And I want to access to the interview
    Then I want to see the plans with  description<description>,posts <postulations>, video <video_duration> and duration <duration>
    Examples:
      | description                  | postulations  | video_duration      | duration |
      |      "plan_unlimited"        |    3          |       5             |  30      |