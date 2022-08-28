FROM openjdk:11
ARG JAR_FILE=target/product-CRUD-API-0.0.1-SNAPSHOT.jar
COPY ./target product-CRUD-API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/product-CRUD-API-0.0.1-SNAPSHOT.jar"]