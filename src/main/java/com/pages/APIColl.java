package com.pages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.qa.factory.APIFactory;

import io.restassured.response.Response;
import pojos.CryptoCurrencies;
import pojos.Datum;

public class APIColl {

	private static APIFactory apiFactory;

	public APIColl() {
		apiFactory = new APIFactory();
	}

	private static String currID = null;
	private static Response response = null;

	// @Step("Retrieve Currency ID")
	public int retrieveCurrencyID(String currency_symbol) {
		int id = 0;
		String endPoint = "/cryptocurrency/map";
		HashMap<String, String> parameter = new HashMap<>();
		parameter.put("symbol", currency_symbol);
		Response response = apiFactory.executeRequest(endPoint, APIFactory.RequestMethod.GET, parameter, 200);

		CryptoCurrencies curriencies = response.as(CryptoCurrencies.class);
		List<Datum> allCurrenciesList = curriencies.getData();

		for (Datum data : allCurrenciesList) {
			if (data.getSymbol().equalsIgnoreCase(currency_symbol)) {
				id = data.getId();
				System.out.println("\n--------------->>> matching currency is at ID = " + id);
			}
		}

		Assert.assertTrue("Error while execute the request",
				Integer.parseInt(apiFactory.getResponseValue(response, "status.error_code")) == 0);

		return id;

	}

	// @Step("Convert Currency")
	public void convertToCurrency(int baseCurrencyID, String convertTo_Currency, int amount) {
		try {
			String endPoint = "/tools/price-conversion";
			HashMap<String, String> parameter = new HashMap<>();
			parameter.put("id", String.valueOf(baseCurrencyID));
			parameter.put("amount", String.valueOf(amount));
			parameter.put("convert", convertTo_Currency);

			response = apiFactory.executeRequest(endPoint, APIFactory.RequestMethod.GET, parameter, 200);

			String attribute = "data.quote." + convertTo_Currency.toUpperCase() + ".price";
			String convrtedAmount = apiFactory.getResponseValue(response, attribute);

			Assert.assertTrue("Error while execute the request",
					Integer.parseInt(apiFactory.getResponseValue(response, "status.error_code")) == 0);
			Assert.assertTrue(
					"Failed to convert amount '" + amount + "', from " + baseCurrencyID + " to " + convertTo_Currency,
					!convrtedAmount.isEmpty());

			System.out.println(
					"\n----------------->>> value of converted corrency is: " + Double.parseDouble(convrtedAmount));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// @Step("Retrieve Technical Document")
	public static synchronized void retrieveTechnicalDoc(int currency_ID) {
		try {
			String endPoint = "/cryptocurrency/info";
			HashMap<String, String> parameter = new HashMap<>();
			parameter.put("id", String.valueOf(currency_ID));
			response = apiFactory.executeRequest(endPoint, APIFactory.RequestMethod.GET, parameter, 200);

			String attribute = "data." + currency_ID + ".urls.website[0]";
			String techDocWebsite = apiFactory.getResponseValue(response, attribute);

			Assert.assertTrue("Technical Documentation Website is Null", techDocWebsite != null);
			Assert.assertTrue("Error while execute the request",
					Integer.parseInt(apiFactory.getResponseValue(response, "status.error_code")) == 0);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

//    @Step("Verify Fields")
	public static synchronized void verifyFields(int currency_ID, String expectedField, String expectedValues) {
		try {
			String attribute;
			switch (expectedField.toLowerCase()) {
			case "technical_doc":
				attribute = "data." + currency_ID + ".urls." + expectedField.toLowerCase() + "[0]";
				break;
			case "tags":
				attribute = "data." + currency_ID + "." + expectedField.toLowerCase() + "[0]";
				break;
			default:
				attribute = "data." + currency_ID + "." + expectedField.toLowerCase();
			}

			String value = String.valueOf(apiFactory.getResponseValue(response, attribute));
			Assert.assertTrue(expectedField + "-" + expectedValues + " mismatch",
					expectedValues.equalsIgnoreCase(value));
			System.out.println(
					"**********" + expectedField + "---" + expectedValues + " validated successfully**********");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Response getCurrencyInfoByID(String id) {
		String endPoint = "/cryptocurrency/info";
		HashMap<String, String> parameter = new HashMap<>();
		parameter.put("id", id);
		// Get response
		response = apiFactory.executeRequest(endPoint, APIFactory.RequestMethod.GET, parameter, 200);
		
		return response;
		

	}

	public boolean isMineableTagPresent(Response response, String id) throws ParseException {
		boolean flag = false;

		Assert.assertTrue(response.getStatusCode() == 200);
		String attribute = "data." + id + ".tags";
		ArrayList<String> tagsList = (ArrayList<String>) response.body().path(attribute);
		System.out.println("\n ------------- >>> tags present in currency => " + tagsList.toString());

		if (tagsList.size() > 0) {
			for (String item : tagsList) {
				if (item.equalsIgnoreCase("mineable")) {
					flag = true;
					System.out.println("------------------->>> currenct id: " + id + " contains mineable tags");
				}
			}
		} else {
			System.out.println("\n--------------->>> tags list is Null");
		}

		return flag;

	}

}