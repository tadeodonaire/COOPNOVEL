FROM eclipse-termurin:23-jdk
WORKDIR /app

COPY . .

# Otogar permisos de ejecición al wrap per de Maven

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

#------------

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
