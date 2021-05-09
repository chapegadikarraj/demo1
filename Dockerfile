FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim
ADD target/Demo1-0.0.1-SNAPSHOT.jar Demo1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Demo1-0.0.1-SNAPSHOT.jar"]