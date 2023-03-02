# Cart Controller endpoints



# 1. Create empty cart

### HTTP Request:
`GET /v1/carts/`

### Body:
**Type:** JSON
```
{
    "products":[]
}
```

### Returns:
empty **JSON**

# 2. Delete cart By Id

### HTTP Request:
`DELETE /v1/carts/{{cartId}}` where {cartId} must be provided

Example:
```
http://localhost:8080/v1/carts/1
```

### Body:
empty

### Returns:
empty **JSON** 

# 3. Get Cart with given ID

### HTTP Request:
`DELETE /v1/carts/{{cartId}}` where {cartId} must be provided with {productId}

Example:
```
http://localhost:8080/v1/carts/1?productId=3
```
### Body:
empty

### Returns:
**JSON** with list products and information about user

Example:
```
{
    "cartId": 1,
    "products": [
        {
            "productId": 1,
            "name": "string",
            "price": 0.0,
            "quantity": 0
        },
        {
            "productId": 133,
            "name": "string",
            "price": 0.0,
            "quantity": 0
        }
    ],
    "user": {
        "userId": 1,
        "name": "test",
        "lastName": "test",
        "address": "test",
        "login": "test",
        "password": "test",
        "cart": {
            "cartId": 1
        },
        "blocked": false,
        "user_key": {
            "value": null,
            "expirationTime": "2023-03-26T08:56:16Z"
        }
    }
}
```

# 4. Put updating cart (list of products)

## HTTP Request:
`PUT v1/carts/cartId?productId=productId`

Example:
```
http://localhost:8080/v1/carts/1?productId=3
```
### Body:
empty **JSON**

### Returns:
**JSON** with list products with new product and information about user

Example:
```{
    "cartId": 1,
    "products": [
        {
            "productId": 3,
            "name": "string",
            "price": 0.0,
            "quantity": 0
        },
        {
            "productId": 1,
            "name": "string",
            "price": 0.0,
            "quantity": 0
        },
        {
            "productId": 151,
            "name": "string",
            "price": 0.0,
            "quantity": 0
        }
    ],
    "user": {
        "userId": 1,
        "name": "test",
        "lastName": "test",
        "address": "test",
        "login": "test",
        "password": "test",
        "cart": {
            "cartId": 1
        },
        "blocked": false,
        "user_key": {
            "value": null,
            "expirationTime": "2023-03-26T08:56:16Z"
        }
    }
}
```

# 5. Creating order based on cart
### HTTP Request:
`DELETE /v1/carts/{{cartId}}` where {cartId} must be provided

Example:
```
http://localhost:8080/v1/carts/1
```
### Body:
empty

### Returns:
empty **JSON**


