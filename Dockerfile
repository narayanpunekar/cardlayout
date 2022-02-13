FROM frolvlad/alpine-java 
LABEL maintainer="Narayan Punekar"
LABEL description="This Dockerfile installs cardlayout"
RUN $JENKINS_HOME 
RUN $PATH_TO_JOB
RUN $BUILD_NUMBER 
COPY build/layout-1.0-SNAPSHOT.jar app.jar  
ENTRYPOINT ["java", "-jar", "app.jar"] 
