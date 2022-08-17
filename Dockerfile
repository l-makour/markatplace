FROM adoptopenjdk/openjdk11
WORKDIR /opt
ADD target/markatplace-*.jar marketplaceLma.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/marketplaceLma.jar"]