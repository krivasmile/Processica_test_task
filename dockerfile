FROM adoptopenjdk/openjdk16:alpine-jre

COPY target/processica_test_task-0.0.1-SNAPSHOT.jar processica_test_task.jar

EXPOSE 8080

cmd ["java", "-jar", "processica_test_task.jar"]