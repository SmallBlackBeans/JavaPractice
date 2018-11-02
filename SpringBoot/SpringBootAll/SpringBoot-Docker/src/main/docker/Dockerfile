# Dockerfile
# 基于的镜像
FROM openjdk:8-jdk-alpine

VOLUME /tmp


ADD SpringBoot-Docker-1.0-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS="-Dspring.profiles.active=dev"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

# 对外端口
EXPOSE 8080