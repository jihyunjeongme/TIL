# Java Validation Example

---

## Guideline

----
### YearMonth
Run the following request POST API to test

`POST  http://localhost:8080/api/user`
```json
{
  "result_code" : "",
  "result_message" : "",
  "data": {
    "name": "홍길동",
    "nick_name" :"",
    "age" : 20,
    "password" : "1111",
    "email" : "ji@gmail.com",
    "phone_number" : "010-1111-1111",
    "register_at" : "2023-06-17T13:05:10",
    "birth_day_year_month": " "
  },
  "error":{
    "error_message" :[
    ]
  }
}
```

Expected result

```json
{
    "result_code": "400",
    "result_message": "Bad Request",
    "data": null,
    "error": {
        "error_message": [
            "data.birthDayYearMonth : {   } 은 it does not fit year month format ex) 20230616",
            "data.birthDayYearMonth : {   } 은 must not be blank"
        ]
    }
}

```

Run the following request POST API to test

`POST  http://localhost:8080/api/user`
```json
{
  "result_code" : "",
  "result_message" : "",
  "data": {
    "name": "홍길동",
    "nick_name" :"",
    "age" : 20,
    "password" : "1111",
    "email" : "ji@gmail.com",
    "phone_number" : "010-1111-1111",
    "register_at" : "2023-06-17T13:05:10",
    "birth_day_year_month": "2023-06"
  },
  "error":{
    "error_message" :[
    ]
  }
}
```

Expected result
```json
{
  "result_code":"200",
  "result_message":"OK",
  "data":{
    "name":"홍길동",
    "nick_name":"",
    "password":"1111",
    "age":20,
    "email":"ji@gmail.com",
    "phone_number":"010-1111-1111",
    "register_at":"2023-06-17T13:05:10",
    "birth_day_year_month":"2023-06",
    "name_check":true
  },
  "error":null
}
```

### PhoneNumber

Run the following request POST API to test

`POST  http://localhost:8080/api/user`
```json
{
  "result_code" : "",
  "result_message" : "",
  "data": {
    "name": "홍길동",
    "nick_name" :"",
    "age" : 20,
    "password" : "1111",
    "email" : "ji@gmail.com",
    "phone_number" : "010-11111111",
    "register_at" : "2023-06-17T13:05:10",
    "birth_day_year_month": "2023-06"
  },
  "error":{
    "error_message" :[
    ]
  }
}

```

Expected result
```json
{
  "result_code": "400",
  "result_message": "Bad Request",
  "data": null,
  "error": {
    "error_message": [
      "data.phoneNumber : { 010-11111111 } 은 it does not fit the mobile phone number format ex) 000-0000-0000"
    ]
  }
}

```