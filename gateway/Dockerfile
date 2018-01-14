FROM fabric8/java-centos-openjdk8-jdk:1.3.1

RUN mkdir /springconsole
COPY target/learning-springcloud-gateway-*.jar /springcloud/learning-springcloud-gateway.jar

EXPOSE 1111
CMD ["java","-jar","-Djava.security.egd=file:/dev/./urandom","/springcloud/learning-springcloud-gateway.jar"]
