FROM eclipse-temurin:21

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8085
ENTRYPOINT ["java", "-jar", "application.jar"]
