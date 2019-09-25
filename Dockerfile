FROM java:8

LABEL maintainer="Vilmos"

VOLUME /tmp

EXPOSE 8080

# The application's jar file
ARG JAR_FILE=todo-webapp/build/libs/todo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} todo-0.0.1-SNAPSHOT.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/todo-0.0.1-SNAPSHOT.jar"]