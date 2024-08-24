FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

WORKDIR /app
COPY ./mvnw /app/mvnw 
COPY .mvn/ /app/.mvn/ 
COPY pom.xml /app/ 
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

CMD ["java", "-jar", "target/task_management_system-0.0.1-SNAPSHOT.jar"]
