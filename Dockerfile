FROM openjdk:11
EXPOSE 8080
ADD target/fastpay-sdk-api-0.0.1-SNAPSHOT.jar fastpay-sdk-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fastpay-sdk-api-0.0.1-SNAPSHOT.jar"]
