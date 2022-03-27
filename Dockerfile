FROM openjdk:8-jre-alpine
MAINTAINER Damir <damirrakhmetulla@gmail.com>

VOLUME /tmp
ARG JAR_FILE
ADD ./target/demo-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]