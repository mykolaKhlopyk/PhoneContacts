# PhoneContacts
Java Internship test task

## Used API
phone numbers validated by using tvilio API (https://www.twilio.com/docs/usage/api)

## API
- sign up: http://localhost:8888/auth/signup
  ```json
  {
    "login":"Bob",
    "password":"123456"
  }
  ```
- sign ip: http://localhost:8888/auth/signin
  ```json
  {
    "login":"Bob",
    "password":"123456"
  }
  ```
- create contact: PUT http://localhost:8888/contacts
  ```json
  {
    "name": "friend1",
    "emails": ["xxxx1@xxxx.com", "yyyy@yyyy.com"],
    "phones": ["+380939323331","+380939333332", "+380119333339"]
  }
  ```
- update contact: POST http://localhost:8888/contacts
  ```json
  {
    "name": "friend1",
    "emails": ["rob@xxxx.com", "yyyy@yyyy.com"],
    "phones": ["+380939399999"]
  }
  ```
- delete contact: DELETE http://localhost:8888/contacts?name=friend1
- get all contacts: GET http://localhost:8888/contacts

## Technologies
- Java
- Spring Boot
- Spring Security + JWT
- Spring MVC
- Hibernate
- PostgreSQL
- Postman



