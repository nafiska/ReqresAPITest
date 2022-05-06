Feature: List Of Users - GET Request Test
      
@API
Scenario Outline: Verify List Of Users 
    Given I have Endpoint To Test API Request for List Of Users
		Then I Verify Successful Status Code as <Statuscode>
		Then I Verify Total Number Of Users Page as <TotalUsersPage>
   
Examples:
      | TotalUsersPage | Statuscode |
      | 2              | 200        |