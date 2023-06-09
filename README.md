# Siemens_Assignment_Spring_Boot
Siemens Software Academy Assignment 

### API Endpoints
#### RequestMapping: ```/api/v1/teachers```
| HTTP Verbs | Endpoints | Action |
| --- | --- | --- |
| GET | ```/withPrefix/?namePrefix=<>``` | To get teacher with first or second name prefix |
| GET | ```/{mail}```| To get teacher by mail |
| POST | ```/api/v1/teachers``` | To create a new teacher  |
| DELETE | ```/{teacherId}``` | To delete a single teacher |

### Technologies Used
* [Spring Boot ](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) This is an open-source Java framework for building standalone, production-ready applications that can be deployed with minimal configuration. It provides a wide range of features and capabilities that simplify the development process, including automatic configuration, dependency management, and embedded web servers.
* [Spring Data JPA ](https://nodejs.org/) This  is a popular Java-based framework used to simplify the development of database-driven applications. It provides a powerful set of abstractions and utilities that allow developers to easily perform common CRUD (Create, Read, Update, and Delete) operations on relational databases using Java Persistence API (JPA) annotations.
