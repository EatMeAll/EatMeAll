FROM jboss/wildfly:14.0.1.Final
USER root
RUN chown -R jboss:0 ${JBOSS_HOME}
RUN chmod -R g+rw ${JBOSS_HOME}
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/
COPY mysql /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main