FROM openjdk:8
EXPOSE 8080
ADD target/menotifique##0.1.2.jar menotifique0.1.2.jar
ENTRYPOINT ["java","-jar","/menotifique0.1.2.jar"]