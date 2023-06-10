FROM eclipse-temurin:17-jdk

VOLUME /tmp

RUN useradd -m usera

USER usera

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
