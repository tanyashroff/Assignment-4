# Assignment 4: Web Testing with Selenium 

1. ## Setup Project (5 points)
    Task 1 (5 points): First you will have to setup this project to run JUnit tests for this assignment. All tests should be in 
    `src/test/java` in the package `edu.umd.enpm614.assignment4`. Google Chrome is required to run your tests, you can 
    install the latest stable version of [Google Chrome from here](https://cloud.google.com/chrome-enterprise/browser/download/).
    This project has been tested with Google Chrome version 81.0 on Mac, Linux, and Windows.
    
    You also have to download [this folder from OneDrive](https://1drv.ms/u/s!Avykl7qyeBxhpC0zs4tfjhBcge6p?e=du1hUX).
    And unzip the contents of the file to `src/test` folder. It should create `resources` directory under `src/test` folder.
    The final directory structure for `src/test` folder should look like this: 
    ```
    src/test
    ├── java
    │   └── edu
    │       └── umd
    │           └── enpm614
    │               └── assignment4
    │                   ├── Assignment4ApplicationTests.java
    │                   └── SeleniumTest.java
    └── resources
        ├── chromedriver_linux64_v88
        ├── chromedriver_linux64_v89
        ├── chromedriver_linux64_v90
        ├── chromedriver_m1_v88
        ├── chromedriver_m1_v89
        ├── chromedriver_m1_v90
        ├── chromedriver_mac64_v88
        ├── chromedriver_mac64_v89
        ├── chromedriver_mac64_v90
        ├── chromedriver_win32_v88.exe
        ├── chromedriver_win32_v89.exe
        └── chromedriver_win32_v90.exe
    
    6 directories, 14 files
    ```
    
    > Do NOT make changes to `src/main/java` or `src/main/resources`. 
    
1. ## Write passing tests for Web Application (20 points)
    Task 2 (20 points): Test the Web App fully according to the 
    [Toy Web Application Specifications](#toy-web-application-specification). You must be 
    familiar with an application before you can write good tests for it, therefore, spend some time playing around 
    with this web application before you start writing tests. 
    > Note: All behaviors of Web App are considered correct, and your test cases for the original Web App 
      should always pass.
1. ## Write strict tests for the web application (25 points)
    Task 3 (25 points): Same as the JUnit Assignment, we will run your JUnit tests against versions of the Web App with
     seeded bugs; you earn points by catching these seeded bugs. The goal here is to encourage you to be thorough and 
     creative with Web Testing.
    
### Submission
When submitting make sure your project build in github otherwise your submission will not be graded.

# Toy Web Application Specification
> The web application is feature complete and current behavior is the desired behavior. Please do not change any
> functionality of the application. This application has two features: Calculator (at `/math`) and Form (at `/form`)

## Calculator
* All user interactions are done through the URL query parameters
* 3 parameters are passed in through the URL

    | Field | Description |
    | ----- | ----------- |
    | `param1` | must be an integer number |
    | `param2` | must be an integer number |
    | `operator` | must be “plus” or “minus” |
    
* Results (math operation results or error messages) will be shown
* Don’t worry about integer value overflow!

## Form
* User interactions are done through HTML form
* 3 fields and a submit button in the form
    
    | Field             | Description |
    | -----             | ----------- |
    | Email Address     | email must have "umd.edu" domain |
    | Color             | any of the 3 selections |
    | I agree		    | must be checked |
    | Submit            | submits form data |
* Review page reviews (displays) all of the form data submitted
* If validations fail, errors are displayed on the page

 
