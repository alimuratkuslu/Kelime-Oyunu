FROM openjdk:17 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR "/app"
COPY --from=build target/*.jar kelime-oyunu.jar
ENTRYPOINT ["java", "-jar", "kelime-oyunu.jar"]