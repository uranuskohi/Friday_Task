
  @api
    Feature: api_testing

      Scenario: TC_01
        Given send a get request for list of users
        And the response status code for lists of users should be 200
        And send a get request for single user with id "11"
        Then the response status code for user should be 200
        And the response should contain user details
        And set the payload for new user
        And send a post request foe new user
        Then the response status code should be 201
        Then set the payload for registration with email only
        When send a post request to register
        Then the response should contain an error message "Missing password"
        And the response status code should be 400



    Scenario: TC_02 Validation of id
      Given user sends a get request from list users
      And get the user id "11"
      And send get request from single user with id "11"
      Then check if values are the same






