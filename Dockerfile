# https://hub.docker.com/r/jenkins/jenkins/tags?page=1&ordering=last_updated
# previous: jenkins/jenkins:2.249.3-lts
FROM jenkins/jenkins:2.263.1-lts

ARG JENKINS_REF_DIR=/usr/share/jenkins/ref

# Disable setup and upgrade wizards
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
RUN echo 2.0 > ${JENKINS_REF_DIR}/jenkins.install.UpgradeWizard.state

# Plugins
COPY plugins.txt ${JENKINS_REF_DIR}/plugins.txt
RUN jenkins-plugin-cli -f ${JENKINS_REF_DIR}/plugins.txt

# CasC
ENV CASC_JENKINS_CONFIG=${JENKINS_REF_DIR}/casc/
COPY casc/ ${CASC_JENKINS_CONFIG}
