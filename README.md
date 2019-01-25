# spring-rest-swagger-project
A Spring REST project which exposes GET, POST and PUT endpoints along with swagger documentation to fetch, save and update a resource in H2(in memory) database

# Run the project

1. git clone https://github.com/amitdhodi/spring-rest-swagger-project.git
2. Import the project as maven project in your IDE
3. Run SwaggerApplication.java, the application would start on default port 8080

# Steps to view swagger documentation

1. Hit the URL: http://localhost:8080/v2/api-docs
2. This would return swagger documentation JSON as response. Copy the JSON response
3. Open the swagger editor (https://editor.swagger.io/). Paste the copied JSON from step2 above into the swagger editor.
4. This would show all the enpoints on the swagger editor UI.

# Steps to test the exposed endpoints

1. Save the resource using POST endpoint

Hit the POST endpoint from POSTMAN or any other tool which allows sending POST requests. Details of the request:

URL: 
http://localhost:8080/v1/resource

Request Body: 
```
{
	"name": "AJ",
	"age": 32
}
```
This will create a resource in H2 in memory database

2. Get the resource using GET endpoint

Hit the GET endpoint to see all resources created. 

URL: http://localhost:8080/v1/resources

3. Update the resource using PUT endpoint

Hit the PUT endpoint from POSTMAN or any other tool which allows sending PUT requests. Details of the request:

URL: 
http://localhost:8080/v1/resource/1/

Request Body: 
```
{
	"name": "Name Changed",
	"age": 35
}
```

