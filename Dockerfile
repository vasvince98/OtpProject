FROM eclipse-temurin:17-jdk

VOLUME /tmp

ARG USERNAME

RUN useradd -m $USERNAME

USER $USERNAME

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
