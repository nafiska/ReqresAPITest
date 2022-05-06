Feature: Single User Data - GET Request Test
      
@API
Scenario Outline: Verify Single User Data - Positive scenario
    Given I have Endpoint To Test API Request for Single User - 2
    Then I Verify Successful Status Code as 200
		Then I Verify Single User Data is displayed - <UserID>
   
Examples:
      | UserID |
      | 2      |

@API
Scenario: Unknown - Verify Single User Data - Negative scenario
    Given I have Endpoint To Test API Request for Single User - 23
    Then I Verify Successful Status Code as 404