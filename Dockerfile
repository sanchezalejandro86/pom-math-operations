FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:latest
ENV JAVA_APP_DIR=/deployments
EXPOSE 8080
COPY target/pom-math-operations-exec.jar /deployments/