FROM frolvlad/alpine-java 
LABEL maintainer="Narayan Punekar"
LABEL description="This Dockerfile installs cardlayout"
COPY /var/jenkins_home/workspace/freestyle-cardlayout/target/layout-1.0-SNAPSHOT.jar app.jar 
ENTRYPOINT ["java", "-jar", "app.jar"] 
