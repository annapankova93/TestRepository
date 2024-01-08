FROM ubuntu:latest

RUN apt-get update && apt-get install -y git openjdk-17-jdk
RUN apt-get install -y git maven 

WORKDIR /docker

RUN git clone https://github.com/annapankova93/TestRepository/

COPY TestRepository-new/jolokia-agent-jvm-javaagent.jar /etc/docker/TestRepository-new/jolokia-agent-jvm-javaagent.jar
    
WORKDIR /docker/TestRepository

RUN mvn clean package

COPY TestRepository-new/target/newrest-0.0.1-SNAPSHOT.jar /etc/docker/TestRepository-new/target/newrest-0.0.1-SNAPSHOT.jar

CMD java -javaagent:/etc/docker/TestRepository-new/jolokia-agent-jvm-javaagent.jar -jar /etc/docker/TestRepository-new/target/newrest-0.0.1-SNAPSHOT.jar
