#!/usr/bin/env bash


mvn clean install
docker build -t zsh9891/spring-cloud-demo-eureka-server:latest eureka/server
docker build -t zsh9891/spring-cloud-demo-eureka-consumer:latest eureka/consumer
docker build -t zsh9891/spring-cloud-demo-eureka-producer:latest eureka/producer
docker build -t zsh9891/spring-cloud-demo-gateway:latest gateway

#docker push zsh9891/spring-cloud-demo-eureka-server:latest
#docker push zsh9891/spring-cloud-demo-eureka-consumer:latest
#docker push zsh9891/spring-cloud-demo-eureka-producer:latest
#docker push zsh9891/spring-cloud-demo-gateway:latest


#minishift start --insecure-registry="192.168.31.34" --registry-mirror=https://e3wtejq8.mirror.aliyuncs.com/ --memory 4GB