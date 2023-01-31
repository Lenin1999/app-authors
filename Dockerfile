

FROM eclipse-temurin:17.0.5_8-jre-alpine

RUN mkdir /app
WORKDIR /app
COPY build/libs/*.jar app.jar

COPY build/libs/libs ./libs


ENV DB_URL=jdbc:postgresql://db:5432/distribuida1
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=12345

#CMD ["java", "-jar", "quarkus-run.jar"]
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080