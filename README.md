# CoinMarketCap

# ToolsStack: 
* Java  
* Selenium
* Cucumber
* RestAssured

# Setup
* Import project as a maven project
* Update Browser in config.properties file
* Update test data in featue file if required
* Run Individual feature file or run both using test runner class


# FrontEnd test 
Frontend test are covered in "UIScenario.Feature". To exeute only frontend test run UIRunner.java under testrunners folder



# Backend test 
Backend test are covered in "APIScenario.Feature". To exeute only Backend test run APIRunner.java under testrunners folder

To execute both frontend and backend tests. Run PrallerRunner.java

API and UI test can also be executed using ```mvn clean test``` command
