FROM openjdk:17 AS builder
COPY . /usr/src/quote-reactive-backend
WORKDIR /usr/src/quote-reactive-backend
RUN ./mvnw clean package

FROM openjdk:17
COPY --from=builder /usr/src/quote-reactive-backend/target/quote-reactive-web-1.0.0-SNAPSHOT.jar /usr/src/quote-reactive-backend/
WORKDIR /usr/src/quote-reactive-backend
EXPOSE 8080
CMD ["java", "-jar", "quote-reactive-web-1.0.0-SNAPSHOT.jar"]
