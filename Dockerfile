FROM frolvlad/alpine-java 
LABEL maintainer="Narayan Punekar"
LABEL description="This Dockerfile installs cardlayout"
COPY /var/jenkins_home/workspace/pipelineone@2/target/layout-1.0-SNAPSHOT.jar 
ENTRYPOINT ["java", "-jar", "app.jar"] 
