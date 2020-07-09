FROM openjdk:8
VOLUME /tmp
ADD target/order-detail-service-1.0.jar order-detail-service-1.0.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "order-detail-service-1.0.jar"]