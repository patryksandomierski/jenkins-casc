# https://hub.docker.com/r/jenkins/jenkins/tags?page=1&ordering=last_updated
# previous: jenkins/jenkins:2.249.3-lts
FROM jenkins/jenkins:2.263.1-lts

# Disable setup and upgrade wizards
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state

# Plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

# CasC
#ENV CASC_JENKINS_CONFIG=/var/jenkins_casc/
#COPY casc/ ${CASC_JENKINS_CONFIG}
