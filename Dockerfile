FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/task-management-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
