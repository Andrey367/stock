FROM maven:3.8.3-openjdk-19 AS build

RUN mkdir /stock-service

COPY . /stock-service

WORKDIR /stock-service

RUN mvn clean package

FROM openjdk:latest

COPY --from=build /stock-service/target/stock-service-1.0.jar /stock-service.jar

CMD java $JAVA_OPTS -jar stock-service.jar