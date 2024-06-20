# Use a imagem base do OpenJDK
FROM openjdk:11-jre-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o JAR gerado para dentro do container
COPY target/assessment-0.0.1-SNAPSHOT.jar assessment.jar

# Defina o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "assessment.jar"]