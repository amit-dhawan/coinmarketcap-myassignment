# coinmarketcap-myassignment

# ToolsStack: 
* Java  
* Selenium
* Cucumber
* RestAssured
* TestNG
* Maven

# Setup
* Import project as a maven project
* Update Browser in config.properties file
* Update test data in featue file if required
* Run Individual feature file or run both using test runner class

# To execute UI tests
UI tests are covered in "UIScenario.Feature". 
To exeute only UI tests run UIRunner.java under testrunners folder by right clicking on it and select Run as => TestNG Test

# To execute API tests
Backend test are covered in "APIScenario.Feature".
To exeute only API tests run APIRunner.java under testrunners folder by right clicking on it and select Run as => TestNG Test


# To execute both UI and API tests. 
Run PrallerRunner.java by right clicking on it and select Run as => TestNG Test

# You can also execute the API and UI tests via:
command line or on Jenkins using command "mvn clean test"
