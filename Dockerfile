FROM amazoncorretto:17

WORKDIR /opt/app

COPY target/carsales-0.0.1-SNAPSHOT.jar* /opt/app

USER nobody

CMD [ "java", "-jar", "carsales-0.0.1-SNAPSHOT.jar" ]