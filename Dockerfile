FROM openjdk:11-jre-slim

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

RUN ./mvnw package

CMD ["java", "-jar", "target/IndiGoBackend-0.0.1-SNAPSHOT.jar"]