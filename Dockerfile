FROM frolvlad/alpine-java 
LABEL maintainer="Narayan Punekar"
LABEL description="This Dockerfile installs cardlayout"
RUN echo ${JENKINS_HOME} 
RUN echo ${PATH_TO_JOB}
RUN echo ${BUILD_NUMBER} 
COPY ./target/layout-1.0-SNAPSHOT.jar app.jar  
ENTRYPOINT ["java", "-jar", "app.jar"] 
