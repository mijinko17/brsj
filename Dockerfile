FROM gradle:8.9.0-jdk21 AS builder
WORKDIR /build

# To cache downloading dependencies, copy only gradle file and build once.
COPY *.gradle gradle.* gradlew /build/
COPY gradle/ /build/gradle/
RUN ./gradlew build -x test --parallel --continue > /dev/null 2>&1 || true

# Build with production code.
COPY . .
RUN ./gradlew build -x test --parallel

FROM amazoncorretto:21.0.3-al2023
WORKDIR /app
COPY --from=builder /build/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"] 