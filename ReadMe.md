POST: Create a student

            Endpoint: http://localhost:8080/student-management-system/api/v1/students <br>
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students <br>
            Requests JSON-Body: {  
                                    "firstName": "Birger",
                                    "lastName": "Birgersson", 
                                    "email": "birger.birgersson@email.com" 
                                } 
            Result: { 
                        "id": 1, 
                        "firstName": "Birger",
                        "lastName": "Birgersson", 
                        "email": "birger.birgersson@email.com" 
            } 

GET: Get a student by Id 

            Endpoint: http://localhost:8080/student-management-system/api/v1/students/1 
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students/1 
            Result: { 
                        "id": 1,               
                        "firstName": "Birger", 
                        "lastName": "Birgersson", 
                        "email": "birger.birgersson@email.com" 
                    } 

GET: Get a student by Last Name 

            Endpoint: http://localhost:8080/student-management-system/api/v1/students/lastname
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students/lastname?lastName=Birger 
            Result: { 
                        "id": 1,                     
                        "firstName": "Birger", 
                        "lastName": "Birgersson", 
                        "email": "birger.birgersson@email.com" 
                    } 
            
GET: Get a list with all Students

            Endpoint: http://localhost:8080/student-management-system/api/v1/students 
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students 
            Result: { 
                        "id": 1,                 
                        "firstName": "Birger", 
                        "lastName": "Birgersson", 
                        "email": "birger.birgersson@email.com" 
                    }, 
                    { 
                        "id": 2,                
                        "firstName": "Axel", 
                        "lastName": "Axelsson", 
                        "email": "axel.axelsson@email.com"
                    } 
            
PUT: Update Students info

            Endpoint: http://localhost:8080/student-management-system/api/v1/students 
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students?firstName=BIRGER 
            Requests JSON-Body: { 
                                    "id": 1,
                                    "firstName": "Updated_Birger",
                                    "lastName": "Updated_Birgersson",
                                    "email": "updated.birger.birgersson@email.com"
                                }
            Result: {
                        "id": 1,
                        "firstName": "Updated_Birger",
                        "lastName": "Updated_Birgersson",
                        "email": "updated.birger.birgersson@email.com"
                    }

PATCH: Update Students First Name

            Endpoint: http://localhost:8080/student-management-system/api/v1/students/update/first-name/1 
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students/update/first-name/1?firstName=Updated_Birgers_FirstName 
            Result: {
                        "id": 1,
                        "firstName": "Updated_Birgers_FirstName",
                        "lastName": "Updated_Birgersson",
                        "email": "updated.birger.birgersson@email.com"
                    }

DELETE: Delete a Student by Id

            Endpoint: http://localhost:8080/student-management-system/api/v1/students/1
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students/1