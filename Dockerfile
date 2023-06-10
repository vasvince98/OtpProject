FROM eclipse-temurin:17-jdk

VOLUME /tmp

ARG USERNAME

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn package

RUN useradd -m $USERNAME

USER $USERNAME

ENTRYPOINT ["java","-jar","/app/target/OtpProject-0.0.1-SNAPSHOT.jar"]
