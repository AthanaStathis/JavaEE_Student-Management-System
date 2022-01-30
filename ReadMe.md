Connection to H2-Database:

    http://localhost:8080/student-management-system/h2/login.jsp?jsessionid=0495721e3ba3bf4d9fe96b91a6c08c4f


POST: Create a student

            Endpoint: http://localhost:8080/student-management-system/api/v2/students 
            URL-Preview: http://localhost:8080/student-management-system/api/v1/students 
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

POST: Create a teacher

            Endpoint: http://localhost:8080/student-management-system/api/v2/teachers
            Requests JSON-Body: {  
                                    "firstName": "Francesco",
                                    "lastName": "Skavolini"
                                } 
            Result: {
                        "firstName": "Francesco",
                        "lastName": "Skavolini"
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

GET: Get a list with all Teachers

            Endpoint: http://localhost:8080/student-management-system/api/v2/teachers
            Result: {
                        "firstName": "Manos",
                        "id": 1,
                        "lastName": "Chatzidakis"
                    },
                    {
                        "firstName": "Anders",
                        "id": 2,
                        "lastName": "Nordlund"
                    }

GET: Get a list with all Subjects

            Endpoint: http://localhost:8080/student-management-system/api/v2/subjects
            Result: {
                        "category": "Humanitarian Sciences",
                        "id": 1,
                        "name": "Sociology of Science",
                        "students": [
                            {
                                "email": "giorgos.proklos@email.com",
                                "firstName": "Giorgos",
                                "id": 2,
                                "lastName": "Proklos",
                                "phoneNumber": "210-4321367"
                            },
                            {
                                "email": "ioannis.latremenos@email.com",
                                "firstName": "Ioannis",
                                "id": 4,
                                "lastName": "Latremenos",
                                "phoneNumber": "210-5326555"
                            }
                        ],
                        "teacher": {
                            "firstName": "Manos",
                            "id": 1,
                            "lastName": "Chatzidakis"
                        }
                    },
                    {
                        "category": "Engineering Physics",
                        "id": 2,
                        "name": "Nuclear Engineering",
                        "students": [
                            {
                                "email": "aris.liapis@email.com",
                                "firstName": "Aris",
                                "id": 1,
                                "lastName": "Liapis",
                                "phoneNumber": "210-5231212"
                            },
                            {
                                "email": "ioannis.latremenos@email.com",
                                "firstName": "Ioannis",
                                "id": 4,
                                "lastName": "Latremenos",
                                "phoneNumber": "210-5326555"
                            },
                            {
                                "email": "nasos.gliatas@email.com",
                                "firstName": "Nasos",
                                "id": 3,
                                "lastName": "Gliatas",
                                "phoneNumber": ""
                            }
                        ],
                        "teacher": {
                            "firstName": "Anders",
                            "id": 2,
                            "lastName": "Nordlund"
                        }
                    },
                    {
                        "category": "Mathematics",
                        "id": 3,
                        "name": "Numerical Analysis",
                        "students": [
                            {
                                "email": "nasos.gliatas@email.com",
                                "firstName": "Nasos",
                                "id": 3,
                                "lastName": "Gliatas",
                                "phoneNumber": ""
                            }
                        ],
                        "teacher": {
                            "firstName": "Anders",
                            "id": 2,
                            "lastName": "Nordlund"
                        }
                    }


PUT: Update Students info

            Endpoint: http://localhost:8080/student-management-system/api/v2/students  
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

PUT: Update Teachers info

            Endpoint: http://localhost:8080/student-management-system/api/v2/teachers
            Requests JSON-Body: { 
                                    "id": 1,
                                    "firstName": "Updated_Teachers_Firstname",
                                    "lastName": "Updated_Teachers_Lastname"
                                }
            Result: { 
                        "id": 1,
                        "firstName": "Updated_Teachers_Firstname",
                        "lastName": "Updated_Teachers_Lastname"
                    }

PUT: Update Subjects info

            Endpoint: http://localhost:8080/student-management-system/api/v2/subjects
            Requests JSON-Body: {
                                    "id": 1,
                                    "category": "Linguistic Studies",
                                    "name": "Poesi",
                                    "students": [
                                                    {
                                                        "email": "giorgos.proklos@email.com",
                                                        "firstName": "Giorgos",
                                                        "id": 2,
                                                        "lastName": "Proklos",
                                                        "phoneNumber": "210-4321367"
                                                    }
                                                ]
                                }
            Result: {
                        "category": "Linguistic Studies",
                        "id": 1,
                        "name": "Poesi",
                        "students": [
                            {
                                "email": "giorgos.proklos@email.com",
                                "firstName": "Giorgos",
                                "id": 2,
                                "lastName": "Proklos",
                                "phoneNumber": "210-4321367"
                            }
                        ]
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

DELETE: Delete a Subject by Id

            Endpoint: http://localhost:8080/student-management-system/api/v2/subjects/1
            Result: 200 OK
