FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
COPY ./db ./db
ENTRYPOINT ["java", "-jar", "application.jar"]