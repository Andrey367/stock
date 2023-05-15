FROM maven:3.9.1-amazoncorretto-20 AS build

RUN mkdir /stock

COPY . /stock

WORKDIR /stock

RUN mvn clean package

FROM openjdk:latest

COPY --from=build /stock/target/stock-1.0.jar /stock.jar

CMD java $JAVA_OPTS -jar stock.jar