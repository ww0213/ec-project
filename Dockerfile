# 使用 OpenJDK 17 作為基底
FROM openjdk:17-jdk-slim
# 設定環境變數
ENV SPRING_PROFILES_ACTIVE=docker
# 設定工作目錄
WORKDIR /app
# 複製 JAR 檔案到容器內
COPY target/ec-0.0.1-SNAPSHOT.jar app.jar
# 執行 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "app.jar"]