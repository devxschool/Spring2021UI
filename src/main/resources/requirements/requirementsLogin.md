#Digital Bank Web Application
##### Test Username: JohnDoe@testemail.com
##### Test Password: Password1


``` 
TODO: 

1. Create negative and positive scenarios in DigitalBankRegistration.feature file 
based on the given requirements for Login and Account Creation functionalities.
Practice scenario/scenario outlines with example tables
2. Implement your scenarios in DigitalBankRegistrationSteps class. 
3. Implement Driver class based on given requirements in the class.
4. Implement MockData class based on given requirements in the class.
5. Use best practices to locate a webelemnets using:
 - Id locator
 - Name locator
 - linkText & Partial linkText
 - CSS Selector
 - XPath
```
     
### Login Requirements:
 
  utilities.User Navigates to Digital Bank login page: http://3.131.35.165:8080/bank/login
  
A. Fill out login credential:
* The customer will enter the following information to login UserName(Email address) and Password
* The customer will be presented with a screen asking for email address and password.
* The UI will present an error message if any credentials are invalid.
* Verify that username and password fields are displayed in the UI.
* Verify that 'Sign Up Here' link is displayed in Login Page 


B. Submit login credentials:
 
* The customer will be able to click submit button
* If form is empty and user clicks submit, UI will present an error message "Invalid credentials or access not granted."

C. Error message for invalid credentials:
* The UI will present a generic error message for invalid credentials
* Email VALID, password INVALID:  Message: Invalid credentials or access not granted.
* Email INVALID, password VALID: Message: Invalid credentials or access not granted.
* Email INVALID, password INVALID: Message: Invalid credentials or access not granted.
* Email VALID, password VALID: Message: Access granted. utilities.User redirected to Digital Bank Home page




---------
---------
### Account Creation Requirements:

utilities.User Navigates to Digital Bank login page: http://3.131.35.165:8080/bank/signup

A. Fill out account creation fileds:
* Title: Dropdown. Selection options: Mr., Ms., Mrs.
* First name: Input field.
* Last name: Input field.
* Gender: Radio button. Options: M, F
* Date of Birth: Input Filed. ex. MM/DD/YYYY
* Social security number: ex. 123-45-6789 SSN should be unique for each account. 
* Email address: ex. user@gmail.com. Email address should be unique for each account. 
* Password: Input field. Password must contain at least one number, and one uppercase and lowercase letter,
 and at least 8 or more characters.
* Confirm Password:  Input field. Password should match with the input in Password field.
 
 After completing first part of account creation, utilities.User will be redirected to second part to fill out Address information.
 
* Address: Input field. ex. 123 Digital Lane
* Locality: Input field. ex. Internet City
* Region: Input field. ex. CA
* Postal Code: Input field. ex. 92192
* Country: Input field. ex. US
* Home Phone: Input field. ex. (547) 392-5436
* Moble Phone: Input field. ex. (547) 392-5436
* Work Phone: Input field. ex. (547) 392-5436

After utilities.User filled out Address and Contact information, 
utilities.User should accept: Agree the terms and policy (check the checkbox)
And utilities.User should click on Register button
Then utilities.User should be redirected to register page: http://3.131.35.165:8080/bank/register
And utilities.User should see "Success Registration Successful. Please Login." message
And utilities.User should enter valid Password and Sign in 







