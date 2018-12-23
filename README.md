## Money Formatting

*FormatMoney* it’s a small utility which take dynamically from the user input any number and it return the string representation in it decimal form. (eg 1600 -> 1 600.00)

### Project Code Structure

 app/src contains
  - androidTest (automated UI test)
    - assets (contains the feature files BDD story)
    - StepDefinitions (actual test code)
    - testRunners (glue between feature files and step definition files)
 - Main (source code of the app)
    - res (contains the UI layout elements)
    - formatmoney
      - utilities (contains the class NumbersGenericUtils where the function format money is implemented)
      - Main.java (the app context)
 - test (contains unit test for the class NumbersGenericUtils)
 
 ### Test Basis
 
- Check the functionalities fo the code that correctly translate numbers to a string in decimal form
- Check the code implementation is able to handle unxpected input or expections gracefully
- Check the UI allow to capture the user input and pass it to the backend
- Check all the elements of the UI are correcly pesent, displayed and interactivable


 ### Test Methodologies
 - Unit Testing
    - Boundary Value Analysis
    - Equivalence Partitioning
    - Mutation Testing
    - Fuzz Testing(only prove of concept)
 - Integration Testing
 - System Testing
    - Regression Testing
    - UAT 
 
 
### Requirements
The project was implemented with Android Studio 3.2 and debugged on a Nexus 5 device with API level 27(oreo), unit test have been performed with Junit for Android, the UI automated tests have been implemented and performed with Android Espresso 3.0.2

- Gradle 4.9
- JDK 1.8
- Android SDK 27

**- To run the APP the Main class need to be executed**

**- To run Unit test : ./gradlew test**

**- To run UI automated test(simulator should be up and running): ./gradlew connectAndroidTest**
 
 
