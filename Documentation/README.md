# RideShare UserService
This folder contains the Open API Documentation for the Rideshare User Service back-end.

## DatabaseInfo Folder
This folder contains the script necessary to create and populate tables for the entities.

## RideShare Previous Version
[index.html](index.html): This is the updated project's html file as of March 2, 2020.  
[rideshare.yaml](rideshare.yaml): This is the updated project's yaml file as of March 2, 2020. You can use this to edit on [Swagger-IO](https://swagger.io)

## Running API Documentation on the Localhost
[Swagger-UI](http://localhost:9999/swagger-ui/index.html?url=/v3/api-docs): To see the API Documentation when running the localhost. Note: The errors aren't appropriately documented here. 

#### Password Encryption
In the EmployeeServiceImpl, uncomment the functions in addEmployee and updateEmployee to have password encryption.

```
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(employee.getPassword());
        employee.setPassword(encryptedPassword);
``` 

You'll need to edit the login method to check the plaintext vs the database's encryption. 
```
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		
		if (passwordEncryptor.checkPassword(password, e.getPassword())) {
			return e;
		}else {
			return null;
		}
```
