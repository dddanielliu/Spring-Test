FROM maven:3.9-eclipse-temurin-21 AS dev

RUN apt update \
    && apt install -y --no-install-recommends \
        iputils-ping curl htop tmux vim

ARG PROJECT_PATH=/Spring-test/backend
WORKDIR ${PROJECT_PATH}

RUN --mount=type=bind,source=pom.xml,target=${PROJECT_PATH}/pom.xml \
    mvn dependency:resolve
    # mvn dependency:go-offline

