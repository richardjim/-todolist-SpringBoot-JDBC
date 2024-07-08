FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
ADD target/todolist-0.0.1-SNAPSHOT.jar todolist.jar
ENTRYPOINT ["java","-jar","/todolist.jar"]
