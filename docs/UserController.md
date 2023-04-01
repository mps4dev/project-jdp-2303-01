# User Controller endpoints

## 1. Create user

### HTTP Request:
`POST v1/users/user`
### Body:
**Type:** JSON

```
{
    "userId": 1,
    "name": "testName",
    "lastName": "testLastName",
    "address": "testAddress",
    "login": "testLogin",
    "password: "testPassword"
}
```
### Returns:
empty **JSON**

## 2. Block user

### HTTP Request:
`POST /v1/users/{userid}/block`
### Body:
empty
### Returns:
empty **JSON**

**or** Exception - if there is no product with such ID


## 3. Generate token for user valid 1hr
POST `/{userId}/keygenerate` where userId must be provided
### Body:
empty
### Returns:
empty **JSON**