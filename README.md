# micro-product-springboot
A **REST API** connected to a **PostgreSQL** database with its own **CRUD** operations, URL, and HTTP methods. It’s connected to a **Gateway Server** and **Eureka Server**.

Resouce Paths.
- POST: http://localhost:8001/api/product/list/retrieve
- POST: http://localhost:8001/api/product/id/retrieve
- POST: http://localhost:8001/api/product/create

JSON Body:

{
>"name": "Whiteboard Markers",\
"description": "Pack of 4 black whiteboard markers",\
"quantity": 2,\
"price": 6.99,\
"date": "15/01/2024",\
"code": "9873453672819235"


}

- PUT: http://localhost:8001/api/product

JSON Body (same as the previous one but including the **id** field):

- DELETE: http://localhost:8001/api/product/remove
