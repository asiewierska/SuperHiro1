RD /S /Q "C:\Program Files\apache-tomcat-8.5.16\webapps\Profile-webapp-0.0.1-SNAPSHOT"
COPY "C:\Users\as\workspace\SuperHiro1\target\Profile-webapp-0.0.1-SNAPSHOT.war" "C:\Program Files\apache-tomcat-8.5.16\webapps"
CD "C:\Program Files\apache-tomcat-8.5.16\bin"
startup.bat