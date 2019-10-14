FROM openjdk:8-jdk-alpine
ADD build/libs/webflux-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
COPY ./build/libs/*.jar ./webflux.jar
ENTRYPOINT ["java", "-Xms1024m", "-Xmx1024m", "-Dfile.encoding=UTF8", "-Duser.timezone=America/Sao_Paulo", "-jar", "/webflux.jar"]
