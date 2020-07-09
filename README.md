# user-order-service-demo
Three micro-services (User Service, Order service, Aggregator service)

1.	User Service – Will provide a REST endpoint giving details of user (it should return your name and email id being fetched from a database of your choice)
GET /user/1
{
  "name": "John",
  "age": "23",
  "email": "john.doe@google.com"
}

2.	Orders Service – Will give a list of all orders of a user. (it should return a predefined list, no database needed in this microservice)
GET /orders/1
{
  "orders": [
    {
      "orderId": 1,
      "orderAmount": 250,
      "orderDate": "14-Apr-2020"
    },
   {
      "orderId": 2,
      "orderAmount": 450,
      "orderDate": "15-Apr-2020"
    }
  ]
}

3.	Aggregator Service – Will aggregate the response from user and orders service to give following response (should get data from user and order service’s rest endpoint)
GET /orderdetails/1
{
  "userDetails": {
    "name": "John",
    "age": "23",
    "email": "john.doe@google.com"
  },
  "orders": [
    {
      "orderId": 1,
      "orderAmount": 250,
      "orderDate": "14-Apr-2020"
    },
    {
      "orderId": 2,
      "orderAmount": 450,
      "orderDate": "15-Apr-2020"
    }
  ]
}

