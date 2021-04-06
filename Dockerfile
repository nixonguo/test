FROM registry.redhat.io/jboss-eap-7/eap73-openjdk8-openshift-rhel7

USER root

RUN yum install git -y

### DOWNLOAD FROM GIT 

RUN git clone -b dockerfile https://github.com/nixonguo/test.git /tmp/apps

### COPY TO DEPLOYMENT

RUN cp /tmp/apps/test.war $JBOSS_HOME/standalone/deployments/ROOT.war

### ORACLE DB DRIVER 

RUN mkdir -p $JBOSS_HOME/modules/com/oracle/main

RUN cp /tmp/apps/modules/com/oracle/main/* $JBOSS_HOME/modules/com/oracle/main

### CUSTOM CONFIG 

RUN cp /tmp/apps/config/standalone-openshift.xml $JBOSS_HOME/standalone/configuration/standalone-openshift.xml

### ENV VARIABLES

ENV DISABLE_EMBEDDED_JMS_BROKER=true

### RUN JBOSS

RUN chown -R jboss:root $JBOSS_HOME && chmod -R ug+rwX $JBOSS_HOME

USER jboss 

CMD $JBOSS_HOME/bin/openshift-launch.sh
