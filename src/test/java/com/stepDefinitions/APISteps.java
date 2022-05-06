package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.request.reqresTest.api.CreateAccount;
import com.response.reqresTest.api.ResponseDeserializeJSON;
import com.response.reqresTest.api.ResponseDeserializeJSON2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.reqres.endpoint.Endpoints;

public class APISteps {

	private static Response response;
	private static final Logger LOGGER = LoggerFactory.getLogger(APISteps.class);
	
	@Given("I have Endpoint To Test API Request for List Of Users")
	public void getRequestListOfUsers() throws InterruptedException, FileNotFoundException, IOException, ParseException{
		response = Endpoints.getUsersList();
	}
	
	@Then("I Verify Successful Status Code as {int}")
	public void verifyResponseCode(int Statuscode) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		int result = response.statusCode();
		Assert.assertEquals(Statuscode, result);
	}
	
	@Then("I Verify Total Number Of Users Page as {int}")
	public void verifyTotalNumberOfUsersPageListCount(int TotalUsersPage) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		ResponseDeserializeJSON responseData = response.getBody().as(ResponseDeserializeJSON.class);
		Assert.assertEquals(TotalUsersPage, responseData.total_pages);
	}
	
	@Given("I have Endpoint To Test API Request for Single User - {int}")
	public void getRequestSingleUser(int id) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		response = Endpoints.getSingleUserData(id);
	}
	
	@Then("I Verify Single User Data is displayed - {int}")
	public void verifySingleUserData(int userID) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		ResponseDeserializeJSON2 responseData = response.getBody().as(ResponseDeserializeJSON2.class);
		LOGGER.info("Single User ID : " + responseData.data.id);
		Assert.assertEquals(userID, responseData.data.id);
	}
	
	@Given("I have Endpoint To Test API Request for Creating a User with {string} and {string}")
	public void createSingleUser(String name, String job) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		response = Endpoints.createSingleUser(name, job);
	}

	@Then("I Verify User Created Successfully for {string}")
	public void verifyUserCreation(String name) throws InterruptedException, FileNotFoundException, IOException, ParseException{
		String resultString = response.asString();
		boolean result = false;
		if(resultString.contains(name)) {
			result = true;
		}
		Assert.assertEquals(result, true);
	}
}
