FROM gradle:8.9.0-jdk21 AS builder
WORKDIR /build
RUN apt update && apt install findutils
COPY . .
RUN ./gradlew build

FROM amazoncorretto:21.0.3-al2023
WORKDIR /app
COPY --from=builder /build/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"] 