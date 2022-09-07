# Cidenet API Challenge

## Technologies

* Git
* Java 11
* Docker
* Spring Framework
* Spring Validation
* Postgres
* Maven
* Hibernate
* Swagger
* Maven

## Banco de Dados

### Postgres

[Postgres Docker Hub](https://hub.docker.com/_/postgres)

* Create a new Postgres DB named cidenet on Docker and let the container listen the port 5432 as per default, default User and Password is **postgres**.

_If you want to change any of the informations given above, it must be also changed in applications.properties file._

```shell script
docker run --name cidenetDB -d -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=cidenet postgres
```
