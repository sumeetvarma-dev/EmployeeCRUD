All the Rest APIs for all CRUD Operations

{
	"info": {
		"_postman_id": "3f5d6a2c-2abd-433c-959c-cf9434a8b172",
		"name": "EmployeeCrud",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		 
		{
			"name": "Get All Employees",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/employee",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"employee"
					]
				}
			},
			"response": [{"id":1,"name":"Sumeet","address":"Pune"}] HTTP/1.1 200 OK
		},




  
		{
			"name": "Get Employee By Id",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/employee/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"employee",
						"1915"
					]
				}
			},
			"response": {"id":1,"name":"Sumeet","address":"Pune"} HTTP/1.1 200 OK
		},
		
  
  
  
  
  		{
			"name": "Add Employee",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n       \r\n        \"name\": \"John\",\r\n        \"address\": \"Hadapsar\"\r\n    }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/employee",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"employee"
					]
				}
			},
			"response": Employee Added:: true  HTTP/1.1 201 Created
		},
		
  
  
  
  
  		{
			"name": "Update Employee",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \"name\": \"Hrithik Roshan\",\r\n        \"address\": \"London\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/employee/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"employee",
						"324"
					]
				}
			},
			"response": {"id":324,"name":"Hrithik","address":"London"} HTTP/1.1 200 OK
		},
		
  
  
  
  
  		{
			"name": "Delete Employee",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/employee/613",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"employee",
						"613"
					]
				}
			},
			"response": Employee Deleted   HTTP/1.1 202 Accepted
		}




  		
	]
}
