FROM openjdk:11
COPY target/*.jar exchange-rate-api.jar
ENV JAVA_OPTS=""
EXPOSE 52002
ENTRYPOINT ["java", "-jar", "exchange-rate-api.jar"]