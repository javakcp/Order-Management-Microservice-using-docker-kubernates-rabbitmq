FROM openjdk:8-jre
ADD target/order-service-0.0.1-SNAPSHOT.jar /opt/lib/
EXPOSE 9300
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/lib/order-service-0.0.1-SNAPSHOT.jar"]