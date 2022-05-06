package pages.reqres.endpoint;

import com.request.reqresTest.api.CreateAccount;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
	
	private static final String BASE_URL = "https://reqres.in/";
	
	public static Response getUsersList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.get("/api/users?page=2");
        return response;
    }

	public static Response getSingleUserData(int id) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.get("/api/users/"+id);
        return response;
    }
	
	public static Response createSingleUser(String name, String job) {
		CreateAccount createAccount = new CreateAccount(name, job);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.body(createAccount).post("/api/users");
        return response;
    }
	
	
}