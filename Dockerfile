FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER ZAYARLINNNAUNG

# Add the application's jar to the container
COPY target/lattmat-admin-dashboard-1.0.0.jar lattmat-admin-dashboard.jar

EXPOSE 8080

#execute the application
ENTRYPOINT ["java","-jar","/lattmat-admin-dashboard.jar"]
