FROM openjdk:13-alpine
MAINTAINER otajisan

VOLUME /tmp

RUN mkdir /spring-batch-kotlin-example
WORKDIR /spring-batch-kotlin-example

ENV JAVA_OPTS=""
COPY ./build/libs/spring-batch-kotlin-example-0.0.1.jar /spring-batch-kotlin-example
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ./build/libs/spring-batch-kotlin-example-0.0.1.jar" ]
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /spring-batch-kotlin-example/spring-batch-kotlin-example-0.0.1.jar" ]
