FROM openjdk:17-jre-slim

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR file
COPY target/your-spring-boot-app.jar app.jar

# Expose the port your app runs on (typically 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]