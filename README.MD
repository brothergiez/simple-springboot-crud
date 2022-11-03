# Hallo
## _kew kew kew kew kew_

This Is Simple Java CRUD REST full API using spring-boot & mySQL 

## HOW TO USE

make sure in your machine already installed java, maven, mysql, and some other tools and settings to running Spring Boot project. 

**If the above conditions are met, you can run it with the command below**

```sh
$ git clone https://github.com/brothergiez/simple-springboot-crud.git
$ cd simple-springboot-crud
$ ./mvnw spring-boot:run 
```

## ENDPOINTS
**Create New Customer**
```
    Method  : POST
    URL     : http://localhost:8080/api/v1/customers
    Body    : { "custName": "Bambang",
                "custAddress": "Bandung Barat" }
```

```sh
    curl --request POST \
    --url http://localhost:8080/api/v1/customers \
    --header 'Content-Type: application/json' \
    --data '{
            "custName": "Bambang",
            "custAddress": "Bandung Barat"
        }'
```

**Get All Customers**
```
    Method  : GET
    URL     : http://localhost:8080/api/v1/customers
```

```sh
    curl --request GET \
    --url http://localhost:8080/api/v1/customers
```

**Get Customer By ID**
```
    Method  : GET
    URL     : http://localhost:8080/api/v1/customers/{id}
```


```sh
    curl --request GET \
    --url http://localhost:8080/api/v1/customers/1
```

**Update Customer By ID**
`Im using post method coz of delete method not allowed by tomcat.`

```
    Method  : POST
    URL     : http://localhost:8080/api/v1/customers/edit/{id}
    Body    : { "custName": "Bambang",
                "custAddress": "Bandung Barat" }
```

```sh
    curl --request POST \
    --url http://localhost:8080/api/v1/customers/edit/1 \
    --header 'Content-Type: application/json' \
    --data '{
        "custName": "Ndaru",
        "custAddress": "Tebet, Jakarta Selatan"
    }'
```

**Delete Customer By ID**
`Im using post method coz of delete method not allowed by tomcat.`

```
    Method  : POST
    URL     : http://localhost:8080/api/v1/customers/delete/{id}
    Body    : null
```

```sh
    curl --request POST \
    --url http://localhost:8080/api/v1/customers/delete/1
```