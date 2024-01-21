FROM ubuntu:latest
RUN apt-get update && apt-get install -y openjdk-21-jdk 
RUN apt-get install -y maven
RUN apt-get install -y git
WORKDIR /docker
RUN git clone https://github.com/annapankova93/TestRepository.git /docker/
RUN mvn clean package
COPY TestRepository-master/target/newrest-0.0.1-SNAPSHOT.jar /docker/target/newrest-0.0.1-SNAPSHOT.jar
EXPOSE 8778 
EXPOSE 8080
ENTRYPOINT ["java", "-javaagent:/docker/jolokia-2.0.0/agents/jolokia-agent-jvm-javaagent.jar", "-jar", "/docker/target/newrest-0.0.1-SNAPSHOT.jar"]
