FROM maven:3.9.4-eclipse-temurin-21
WORKDIR /app
COPY ./target/product-service-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "product-service-0.0.1-SNAPSHOT.jar"]
