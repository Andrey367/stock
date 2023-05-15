FROM maven:3.9.1-amazoncorretto-20 AS build

RUN mkdir /stock-service

COPY . /stock-service

WORKDIR /stock-service

RUN mvn clean package

FROM openjdk:latest

COPY --from=build /stock/target/stock-1.0.jar /stock-service.jar

CMD java $JAVA_OPTS -jar stock-service.jar