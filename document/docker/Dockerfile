FROM xpros-base:1.0

LABEL authors="shine"

WORKDIR /app

ADD organization-sync-service-0.0.1-SNAPSHOT.jar app.jar

ENV LOG_DIR=/app/logs
ENV TZ=Asia/Shanghai

ENV JAVA_OPTS="-Xms256m -Xmxlg \
               -XX:MetaspaceSize=128m \
               -XX:MaxMetaspaceSize-256m \
               -Xsslm \
               --add-opens java.base/java.lang=ALL-UNNAMED \
               --add-opens java.base/sun.net.util=ALL-UNNAMED \
               -Dspring.datasource.url=jdbc:kingbase8://192.168.17.232:54321/xpros?currentSchema=xpros_boot,sys_catalog&useSSL=false&slowerCaseTableNames=true&autoReconnect=true \
               -Dspring.datasource.username=xpros \
               -Dspring.datasource.password=xpros \
               -Dspring.datasource.driver-class-name=com.kingbase8.Driver \
               -Dspring.jpa.database-platform=org.hibernate.dialect.Kingbase8Dialect \
               -Dspring.jps.hibernate.ddl-auto=update \
               -Dserver.port=8906 \
               -Dsync.auditLog.url=jdbc:kingbase8://192.168.17.148:54321/jpaas?sys_catalog&useSSL=false&slowerCaseTableNames=true&autoReconnect=true \
               -Dsync.login.url=jdbc:kingbase8://192,168.17.148:54321/ipas?sys_catalog&useSSL=false&slowerCaseTableNames=true&autoReconnect=true \
               -Dsync.auditLog.schema=jpaas_system \
               -Dsync.login.userSchema=jpaas_user \
               -Dsync.login.systemSchema=jpaas_system"

ENTRYPOINT exec java ${JAVA OPTS} -jar app.jar -Y