FROM openjdk:11-jdk

ENV DEPLOYMENT_DIR /system-info-reflective

RUN mkdir -p $DEPLOYMENT_DIR
RUN wget -O $DEPLOYMENT_DIR/dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
#COPY dd-java-agent.jar $DEPLOYMENT_DIR

COPY build/libs/system-info-reflective-0.0.1-SNAPSHOT.jar $DEPLOYMENT_DIR

EXPOSE 8080

CMD ["java", "-javaagent:/system-info-reflective/dd-java-agent.jar", "-jar", "/system-info-reflective/system-info-reflective-0.0.1-SNAPSHOT.jar"]

