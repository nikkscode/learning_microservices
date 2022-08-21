# learning_microservices

This is a learning project based on a Udemy course by "in28minutes".

## Overview

| Application name                 | Port                 |
|----------------------------------|----------------------|
| Limits Microservice              | 8080, 8081,...       |
| Spring Cloud Config Server       | 8888                 |
| Currency Exchange Microservice   | 8000, 8001, 8002,... |     
| Currency Conversion Microservice | 8100, 8101, 8102,... |
| Netflix Eureka Naming Server     | 8761                 |
| API Gateway                      | 8765                 |

## URLs

| Application            | URL                                       | Example                                                                |
|------------------------|-------------------------------------------|------------------------------------------------------------------------|
| Eureka                 | http://localhost:8761                     |                                                                        |
| API Gateway            | http://localhost:8765                     | http://localhost:8765/currency-exchange/from/EUR/to/PLN                |
| Currency Conversion MS | http://localhost:8100/currency-conversion | http://localhost:8100/currency-conversion/from/EUR/to/PLN/quantity/899 |
| Currency Exchange MS   | http://localhost:8000/currency-exchange   | http://localhost:8000/currency-exchange/from/EUR/to/PLN                |
| RabbitMq               | http://localhost:15672                    |                                                                        |
| Zipkin                 | http://localhost:9411                     |                                                                        |

