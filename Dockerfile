FROM gradle:4.2.1-jdk8-alpine AS build-env
WORKDIR /home/gradle
ADD . /home/gradle
RUN gradle build

FROM openjdk:8-jre-alpine
COPY --from=build-env /home/gradle/build/libs/gradle.jar /app/app.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar