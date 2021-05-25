# individual-project-vineethcosta
# CMPE 202 Individual Project

Name:  Vineeth Reddy
SJSU ID: 015227810


The aim of this project is to parse data from different file types and dynamically assign parser to parse and identify which company the card belongs to in runtime.
If the card number does not belong to any cards defined and its length is less than 19, then the card is Undefined.
If the card number is more than 19 digits size, then it is an Error.


Steps to be followed to execute locally

1) First clone or download the repository locally and install maven. Open the code in IntelliJ or any other IDE as a maven project 
2) Install the maven dependencies by going to pom.xml in IntelliJ and installing the dependecies using Maven Update.
3) Then, type the following commands by opening the root repository CMPE202
  - mvn compile
  - mvn clean install
  - mvn exec:java -Dexec.mainClass=TestApp -Dexec.args="csv.csv output.csv"  --> To parse the csv file
  - mvn exec:java -Dexec.mainClass=TestApp -Dexec.args="json.json output.json"  --> To parse the json file
  - mvn exec:java -Dexec.mainClass=TestApp -Dexec.args="xml.xml output.xml"  --> To parse the xml file
4) The above step will automatically run test cases as well. You can manually run them by going to the class TestJUnit in the Test package and run them manually by clicking on run tests.
