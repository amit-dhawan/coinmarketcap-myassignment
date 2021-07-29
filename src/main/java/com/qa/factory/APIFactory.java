package com.qa.factory;

import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.Test;

import com.qa.util.ConfigReader;

import static io.restassured.RestAssured.*;

public class APIFactory {
	private ConfigReader configReader;
	Properties prop;

	// Request Method types
	public enum RequestMethod {
		GET, POST, PUT, DELETE
	}

	// executes request and returns response
	public static synchronized Response executeRequest(String endPoint, RequestMethod requestMth, HashMap<String, String> parameter,
			int statusCode) {
		Response response = null;
		try {
			String baseURI = ConfigReader.init_prop().getProperty("baseURI");
			String basePath = ConfigReader.init_prop().getProperty("basePath");
			String accessKey = ConfigReader.init_prop().getProperty("accessKey");
			System.out.println("baseURI : " + baseURI);
			
			RequestSpecBuilder reqSpecBuild = new RequestSpecBuilder();
			reqSpecBuild.setBaseUri(baseURI);
			reqSpecBuild.setBasePath(basePath);
			reqSpecBuild.setAccept(ContentType.JSON);
			reqSpecBuild.addHeader("X-CMC_PRO_API_KEY", accessKey);
			reqSpecBuild.addParams(parameter);
			RequestSpecification requestSpecification = reqSpecBuild.build();
			requestSpecification.log().all();

			ResponseSpecBuilder resSpecBuild = new ResponseSpecBuilder();
			resSpecBuild.expectStatusCode(statusCode);
			resSpecBuild.expectContentType(ContentType.JSON);
			ResponseSpecification responseSpecification = resSpecBuild.build();
			
			System.out.println("*************** LOGGING  REQUEST*****************************");
			response = given().spec(requestSpecification).when().request(requestMth.toString(), endPoint.trim());
			
			System.out.println("*************** LOGGING  RESPONSE*****************************");
			response.then().spec(responseSpecification);
			response.then().log().all();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

	// Get Response value of a attribute
	public String getResponseValue(Response response, String attribute) {
		String responseVal = null;
		try {
			if (response.body().path(attribute) == null)
				responseVal = String.valueOf(responseVal);
			else
				responseVal = response.body().path(attribute).toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseVal;
	}

}