FROM openjdk:17
EXPOSE 8080
ADD target/sprinboot-image-bank.jar sprinboot-image-bank.jar
ENTRYPOINT ["java","-jar","/sprinboot-image-bank.jar"]