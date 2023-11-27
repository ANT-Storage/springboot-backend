<img src='https://avatars.githubusercontent.com/u/151515294?s=400&u=570f52636070e373f5c3a66128f54019cba681b0&v=4' width='100'>  

# ANT STORAGE API

### Structure & Fundamentals  
......................................................................................

#### [ Entity ]
POJO - Data persistence on a DB, all the fields on it represent all the db fields.  

#### [ Repository Interface ]
Extends Spring Data JPA's & provides basic CRUD. We can define custom queries on it.  
  
#### [ Service Layer ]
Contains the business logic of your application. Acts as an intermediary between the controller and the repository.  

#### [ Controller ]
Handles incoming HTTP requests and interacts with the service layer. The endpoints are defined inside.  

#### [ Endpoints ]
Define methods that handle HTTP methods, Path variables ...  
......................................................................................


