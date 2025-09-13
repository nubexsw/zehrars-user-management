# zehrars-user-management

Features

- Feign Client
- JSON and Static and Dynamic filtering
- HATEOAS
- Monitoring with Spring Boot Actuator
- i18N
- OpenAPI and Swagger UI
- Web Services Security
- REST API
- Data Validation
- JPA and Hibernate
- MySQL, PostgreSQL, and H2 Database Support
- Transaction Management
- Versioning REST API (URL, request parameter, request header, media type)

Tools

- Talend API Tester
- Swagger UI http://localhost:8080/swagger-ui/index.html
- H2 Console http://localhost:8080/h2-console
- Docker for MySQL and PostgreSQL
- Postman for API testing


## Docker Commands

docker container run -d -p 5000:5000 in28min/hello-world-python:0.0.1.RELEASE
docker container ls
docker container stop <container_id>

docker build -t in28Min/hello-world-docker:v1 .
docker run -d -p 5000:5000 in28Min/hello-world-docker:v1


docker image ls
docker image rm <image_id>
docker pull zehrars/user-management:latest




docker container run -d -p 8080:8080 --name user-management -e SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/userdb -e SPRING_DATASOURCE_USERNAME=admin -e SPRING_DATASOURCE_PASSWORD=admin zehrars/user-management:latest


docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=userdb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 -d mysql:latest
docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=userdb -p 5432:5432 -d postgres:latest
docker start mysql
docker start postgres
docker stop mysql
docker stop postgres
docker rm mysql
docker rm postgres
docker logs mysql
docker logs postgres
docker exec -it mysql bash
docker exec -it postgres bash
docker ps
docker ps -a
docker images
docker rmi mysql
docker rmi postgres
docker network ls
docker network create my-network
docker network rm my-network
docker inspect mysql
docker inspect postgres
docker-compose up
docker-compose down
docker-compose -f docker-compose.yml up
docker-compose -f docker-compose.yml down
docker-compose -f docker-compose.yml up -d
docker-compose -f docker-compose.yml down -v
docker-compose -f docker-compose.yml logs
docker-compose -f docker-compose.yml ps
docker-compose -f docker-compose.yml exec mysql bash
docker-compose -f docker-compose.yml exec postgres bash
docker-compose -f docker-compose.yml restart mysql
docker-compose -f docker-compose.yml restart postgres
docker-compose -f docker-compose.yml stop mysql
docker-compose -f docker-compose.yml stop postgres
docker-compose -f docker-compose.yml start mysql
docker-compose -f docker-compose.yml start postgres
docker-compose -f docker-compose.yml rm mysql
docker-compose -f docker-compose.yml rm postgres
docker-compose -f docker-compose.yml build
docker-compose -f docker-compose.yml pull
    
docker-compose -f docker-compose.yml push
docker-compose -f docker-compose.yml config
docker-compose -f docker-compose.yml logs -f
docker-compose -f docker-compose.yml logs --tail=100
docker-compose -f docker-compose.yml ps -a
docker-compose -f docker-compose.yml top
docker-compose -f docker-compose.yml version
docker-compose -f docker-compose.yml help
docker-compose -f docker-compose.yml run mysql bash
docker-compose -f docker-compose.yml run postgres bash
docker-compose -f docker-compose.yml run --rm mysql bash
docker-compose -f docker-compose.yml run --rm postgres bash
docker-compose -f docker-compose.yml run --service-ports mysql
docker-compose -f docker-compose.yml run --service-ports postgres
docker-compose -f docker-compose.yml run --name my-mysql mysql
docker-compose -f docker-compose.yml run --name my-postgres postgres
docker-compose -f docker-compose.yml run --rm --name my-mysql mysql
docker-compose -f docker-compose.yml run --rm --name my-postgres postgres
docker-compose -f docker-compose.yml run --rm --service-ports mysql
docker-compose -f docker-compose.yml run --rm --service-ports postgres
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql sh
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres sh
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql ash
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres ash
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql zsh
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres zsh
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql fish
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres fish
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql csh
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres csh
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql tcsh
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres tcsh
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql ksh
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres ksh
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hlocalhost
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -h localhost"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql userdb"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres userdb"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql -P3306"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres -p5432"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql -P3306 userdb"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres -p5432 userdb"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql -P3306 -e 'SHOW DATABASES;'"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres -p5432 -c '\l'"
docker-compose -f docker-compose.yml run --rm --name my-mysql --service-ports mysql bash -c "mysql -uadmin -padmin -hmysql -P3306 -e 'SHOW TABLES;' userdb"
docker-compose -f docker-compose.yml run --rm --name my-postgres --service-ports postgres bash -c "psql -U admin -d userdb -hpostgres -p5432 -c '\dt' userdb"

## Open Standards for using Tracing, Metrics, and Logging

Micrometer is the instrumentation library for JVM-based applications. It provides a simple facade over the instrumentation clients for a number of monitoring systems.
https://micrometer.io/docs
OpenTelemetry is a set of APIs, SDKs, and tools that can be used to instrument, generate, collect, and export telemetry data (metrics, logs, and traces) to help you analyze your software's performance and behavior.
https://opentelemetry.io/
Zipkin is a distributed tracing system that helps gather timing data needed to troubleshoot latency problems in service architectures.
https://zipkin.io/

## Open Telemetry Commands

Tools and APIS that can be used to collect and export telemetry data (traces, metrics, logs) from applications and services.
https://opentelemetry.io/docs/instrumentation/java/getting-started/



## Creating Docker Images

- Run task bootBuildImage to create a Docker image for the Spring Boot application (stored in the Docker local).
- Use the command docker images to verify that the image has been created successfully.
- Push the Docker image to Docker Hub using the command docker push <your_dockerhub_username>/user-management:latest.
- Or pushing using the task bootPushImage.
- https://hub.docker.com/repositories/tevve2022
- https://hub.docker.com/repository/docker/tevve2022/zehrars-user-management/general
  https://hub.docker.com/repository/docker/tevve2022/zehrars-notification/general

## Deployment in Kubernetes cluster GKE Google Kubernetes Engine

- kubectl version
-  kubectl create deployment zehrars-notification --image=tevve2022/zehrars-notification:0.0.1-SNAPSHOT
-  kubectl create deployment zehrars-user-management --image=tevve2022/zehrars-user-management:0.0.1-SNAPSHOT
