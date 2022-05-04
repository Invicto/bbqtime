FROM maven:3.6.1-jdk-8

RUN mkdir -p /app

WORKDIR /app

COPY . ./

RUN mvn clean package
