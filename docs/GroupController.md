# Group Controller endpoints



## 1. Get all Groups

### HTTP Request:
`GET /v1/groups`

### Body:
empty

### Returns:
**JSON** with list of groups 

Example:
```
]
    {
        "groupId": 44,
        "name": "group2",
        "products": []
    }
]
```
## 2. Get group with given ID

### HTTP Request:
`GET /v1/groups/{{groupId}}` where {groupId} must be provided

```
http://localhost:8080/v1/groups/44
```

### Body:
empty

### Returns:
```
]
    {
        "groupId": 44,
        "name": "group2",
        "products": []
    }
]
```


## 3. Creating new group

### HTTP Request:
`POST /v1/groups`

### Body:
**Type:** JSON

Example:
```
{
    "name": "group3"
}
```
### Returns:
empty **JSON**

## 4. Updating group

### HTTP Request:
`PUT /v1/groups`

### Body:
**Type:** JSON

```
{
        "groupId": 44,
        "name": "grouptest",
        "products": []
    }
```

### Returns:
**JSON** with updated group

