FROM openjdk:8-jre
ADD target/inventory-service-0.0.1-SNAPSHOT.jar /opt/lib/
EXPOSE 9200
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/lib/inventory-service-0.0.1-SNAPSHOT.jar"]