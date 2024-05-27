FROM eclipse-temurin:21-jdk-alpine AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
ADD mvnw .
ADD .mvn .mvn
ADD . $HOME
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /usr/app/target/projet-l3-rent-car-0.0.1-SNAPSHOT.jar /app/runner.jar
ENTRYPOINT java -jar /app/runner.jar