ARG JAVA_BASE_IMAGE=eclipse-temurin:17.0.4_8-jre-focal
ARG MAVEN_BASE_IMAGE=maven:3.8.6-openjdk-18-slim

# Build Stage
FROM $MAVEN_BASE_IMAGE AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Run Stage
FROM $JAVA_BASE_IMAGE
COPY --from=build /home/app/target/currency-exchange-service-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]