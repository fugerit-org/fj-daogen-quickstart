# fj-daogen-quickstart image build 1.0.0
#
# Public built image form amd64/arm64 linux can be found on repository : 
# https://hub.docker.com/repository/docker/fugeritorg/fj-daogen-quickstart/general
#
# create : docker run -it -p 8080:8080 --name fj-daogen-quickstart fugeritorg/fj-daogen-quickstart:latest
# start : docker start fj-daogen-quickstart
# stop : docker stop fj-daogen-quickstart
#
# Image tag : 
# docker image tag [image tag] fugeritorg/fj-daogen-quickstart:latest
#
# Change with any base openjdk image is preferred 
FROM eclipse-temurin:21.0.2_13-jre-alpine

LABEL org.opencontainers.image.authors="Fugerit" \
      org.opencontainers.image.source="SpringBoot" \
      org.opencontainers.image.revision="1.0.0"

VOLUME /tmp
COPY target/fj-daogen-quickstart.jar fj-daogen-quickstart.jar
ENTRYPOINT ["java","-jar","/fj-daogen-quickstart.jar"]