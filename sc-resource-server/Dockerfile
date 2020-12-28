FROM openjdk:11-jdk
MAINTAINER wuqx <wuqx@eastcom-sw.com>

COPY --from=hub.eastcom-sw.com/library/skywalking-agent:8.1.0-es7 /agent /skywalking/agent

ADD ./target/sc-resource-server-2.0.0-SNAPSHOT.jar /app/

RUN echo "Asia/Shanghai" > /etc/timezone

ENV SC_RESOURCE_JAVA_OPTS $SC_RESOURCE_JAVA_OPTS

ENTRYPOINT ["sh","-c","java -jar -Djava.security.egd=file:/dev/./urandom /app/sc-resource-server-2.0.0-SNAPSHOT.jar $SC_RESOURCE_JAVA_OPTS"]
#CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-javaagent:/skywalking/agent/skywalking-agent.jar", "-jar", "/app/sc-resource-server-2.0.0-SNAPSHOT.jar"]

EXPOSE 8001