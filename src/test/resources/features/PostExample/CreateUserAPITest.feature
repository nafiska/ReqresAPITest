Feature: Create An User - POST Request Test
      
@API
Scenario Outline: Verify - Create a Single User 
    Given I have Endpoint To Test API Request for Creating a User with "<Name>" and "<Job>"
		Then I Verify Successful Status Code as <Statuscode>
		Then I Verify User Created Successfully for "<Name>"
   
Examples:
      | Name     | Job    | Statuscode |
      | morpheus | leader | 201        |