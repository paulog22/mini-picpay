# Fase de construção
FROM openjdk:23-jdk-slim as build

WORKDIR /app

# Utilizar o wrapper do Maven incluído no seu projeto para compatibilidade
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src src

# Compilar a aplicação, pulando os testes para agilizar a construção
RUN ./mvnw package -DskipTests

# Fase de execução
FROM openjdk:23-jdk-slim
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]