# product-service/Dockerfile  ← leave exactly like this
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn -q -pl product-service -am package -DskipTests

FROM eclipse-temurin:17-jre
COPY --from=build /workspace/product-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
