FROM frolvlad/alpine-java 
LABEL maintainer="Narayan Punekar"
LABEL description="This Dockerfile installs cardlayout"
COPY $JENKINS_HOME/jobs/$PATH_TO_JOB/builds/$BUILD_NUMBER/layout-1.0-SNAPSHOT.jar app.jar  
ENTRYPOINT ["java", "-jar", "app.jar"] 
