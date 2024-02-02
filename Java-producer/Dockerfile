# Use a base image with Java
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/Producer-1.0-SNAPSHOT.jar /app/

# Specify the command to run your application
CMD ["java", "-jar", "Producer-1.0-SNAPSHOT.jar"]

