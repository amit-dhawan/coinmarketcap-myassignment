package testrunners;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		
		monochrome = true,
		glue = { "Stepdef" },
		features = { "src/test/resources/features/UIScenario.feature" }
//		,tags = "@Frontend_Task2"
)

public class UIRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}