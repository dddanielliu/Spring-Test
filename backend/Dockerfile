FROM maven:3.9-eclipse-temurin-21 AS dev

RUN apt update \
    && apt install -y --no-install-recommends \
        iputils-ping curl htop tmux vim

WORKDIR ${PROJECT_PATH}
