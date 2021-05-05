FROM openjdk:11

WORKDIR app

ADD ./target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]