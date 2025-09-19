FROM eclipse-temurin:24-jdk AS build

WORKDIR /app

COPY . .

RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:24-jdk

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/todolist-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
