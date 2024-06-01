FROM openjdk:17

WORKDIR /app

COPY target/carsales-0.0.1-SNAPSHOT.jar* /app

USER nobody

CMD [ "java", "-jar", "carsales-0.0.1-SNAPSHOT.jar" ]