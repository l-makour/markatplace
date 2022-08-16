FROM adoptopenjdk/openjdk11
WORKDIR /opt
ADD target/markatplace-*.jar marketplace.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/opt/marketplace.jar"]
