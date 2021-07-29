package Stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.text.ParseException;
import java.util.Map;

import com.pages.APIColl;
import com.qa.factory.APIFactory;

public class CoinMktAPIStepDef {

	private APIColl apiObj = new APIColl();
	private int id;

	@Then("^I should see the following fields for currency id \"(.*)\"$")
	public void iShouldSeeTheFollowingFields(int currency_ID, DataTable fields) {
		for (Map<Object, Object> field : fields.asMaps(String.class, String.class)) {
			apiObj.verifyFields(currency_ID, (String) field.get("fields"), (String) field.get("values"));
		}
	}

	@Then("I validate response and mineable tag is associated with currency id {string}")
	public void i_validate_mineable_tag_is_associated_with_currency_id(String currency) throws ParseException {

	}

	@When("I fetch ID for the currency {string}")
	public void iRetrieveTheIDOfCurrency(String currency_symbol) {
		id = apiObj.retrieveCurrencyID(currency_symbol);
	}

	@Then("^I convert \"(.*)\" to \"(.*)\" for \"(.*)\"$")
	public void iConvertToFor(String currency_symbol, String convertTo_Currency, int amount) {
		apiObj.convertToCurrency(id, convertTo_Currency, amount);
	}

	@When("^I fetch the Technical documentation Website for currency id \"(.*)\"$")
	public void iRetrieveTheTechnicalDocumentationWebsiteForCurrencyWithId(int currency_ID) {
		apiObj.retrieveTechnicalDoc(currency_ID);
	}

	@When("I fetch the curriencies by {string}")
	public void i_fetch_the_curriencies_by(String id) {
		apiObj.getCurrencyInfoByID(id);

	}

}