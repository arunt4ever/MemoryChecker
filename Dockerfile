FROM amazoncorretto:11-al2-jdk
RUN yum update -y
COPY target/*.jar MemoryCheck.jar
EXPOSE 8080
#ENV JAVA_OPTS="-Xms512m -Xmx3g"
ENV AWS_REGION=us-west-2
ENV JAVA_OPTS="-XX:MaxRAMPercentage=80 -XX:InitialRAMPercentage=50"
ENTRYPOINT exec java -jar /MemoryCheck.jar $JAVA_OPTS