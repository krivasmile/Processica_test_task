#SOLUTION PROCESSICA TEST TASK

##Project Objective

Create a simple Web Application with RESTful API to interact with the server.
The application will take some text as input data and count number of each word entries as well as number of unique words in the text.
Technical Requirements
Mandatory:
1. Use Maven or Gradle to build the project and resolve its dependencies.
2. Simple server application on the Spring Boot framework.
3. REST controller with an endpoint to process requests from the UI.
4. When the controller receives data - calculate count of unique words and number of their entries in the text.
5. Return response in JSON format (response structure is up to you).
6. Make sure that the API correctly handles various errors.
7. Implement the following schema as the data persistence layer. The schema consists of 2 tables: API requests and their processed statistics. “Request” table contains auto-generated primary key field (id) as well as the text being passed to the API (payload). “Stats” – stores the separate words with the number of entries found in the text. There is a one-to-many relation between the tables (single payload can have more than one unique word).
Choose the database that fits you best (MySQL, PostgreSQL, Mongo, etc.).
8. Keep your code style and the project structure clean (no IDE files, temp files, etc.).

##Optional:

1.	Docker: Docker image build script and compose file will be great additions to the project
2.	Develop JUnit based tests for the Controller and Services.  It should be possible to execute the tests without extra configuration (external DB setup, etc). To accomplish this, use Mockito library to mock the calls to DB or use embedded database for testing.
3.	UI module.
3.1. Simple HTML form with next elements:
- textarea field "Input";
- textarea field "Output";
- button "Proceed";
3.2. Use JavaScript/jQuery to get data from the Input field. On the Proceed button click - send it to the API you’ve developed.
3.3. This should be a POST request to the Server, with JSON document (in any format) to transfer all the text from the Input field.
3.4. Response should be displayed in the Output field, in next format: sorted words in descending order, with count of the entries in the text, and count of the unique words. Example:
Hello - 5
World - 3
Earth - 2
Unique: 3
Please note: Implement only the server side if you don't have any experience with front-end development.
