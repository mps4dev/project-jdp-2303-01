# Product Controller endpoints



## 1. Get all products

### HTTP Request:
`GET /v1/products`

### Body:
empty

### Returns:
**JSON** with array of all products

Example:
```
    {
        "productId": 1,
        "name": "TestProduct",
        "price": 100.0,
        "quantity": 50,
        "group": {
            "groupId": 1,
            "name": "Product Group nr 1"
        }
    },
    {
        "productId": 2,
        "name": "TestProduct2",
        "price": 100.0,
        "quantity": 50,
        "group": {
            "groupId": 1,
            "name": "Product Group nr 1"
        }
    }
]
```
## 2. Get product with given ID

### HTTP Request:
`GET /v1/products/{productId}` where {productId} must be provided

### Body:
empty

### Returns:
**JSON** with product of given ID

Example:
```
{
    "productId": 1,
    "name": "TestProduct",
    "price": 100.0,
    "quantity": 50,
    "group": {
        "groupId": 1,
        "name": "Product Group nr 1"
    }
}
```

**or** Exception: "Product with given Id not found"

## 3. Creating new product

### HTTP Request:
`POST /v1/products`

### Body:
**Type:** JSON

```
{
    "productId": 1,
    "name": "TestProduct",
    "price": 100.0,
    "quantity": 50,
    "group": {
        "groupId": 1,
        "name": "Product Group nr 1"
    }
}
```
### Returns:
empty **JSON**

## 4. Updating product

### HTTP Request:
`PUT /v1/products`

### Body:
**Type:** JSON

```
{
    "productId": 1,
    "name": "Updated Product",
    "price": 100.0,
    "quantity": 50,
    "group": {
        "groupId": 1,
        "name": "Product Group nr 1"
    }
}
```

### Returns:
**JSON** with updated product
```
{
    "productId": 1,
    "name": "Updated Product",
    "price": 100.0,
    "quantity": 50,
    "group": {
        "groupId": 1,
        "name": "Product Group nr 1"
    }
}
```

**or** 500 Internal Server Error - if there is no product/group with such ID


## 5. Deleting product

### HTTP Request:
`DELETE v1/products/{{productId}}` where {productId} must be provided

### Body:
empty

### Returns:
empty **JSON**

**or** 500 Internal Server Error - if there is no product with such ID
