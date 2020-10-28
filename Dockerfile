FROM registry.access.redhat.com/ubi8/openjdk-8

EXPOSE 8080
COPY --chown=jboss target/demo-0.0.1-SNAPSHOT.jar /deployment/app.jar

RUN chmod 777 /deployment/app.jar

ENTRYPOINT ["java", "-jar", "/deployment/app.jar"]