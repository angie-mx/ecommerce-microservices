# -------- build the JAR ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn -q package -DskipTests

# -------- run the JAR ------------
FROM eclipse-temurin:17-jre
COPY --from=build /workspace/product-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
