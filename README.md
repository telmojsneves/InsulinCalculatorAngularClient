Insulin Client
====================

Run Local (Embedded Tomcat):
----------------
  - execute: *mvn tomcat7:run*
  - Then open the URL: http://localhost:8080/InsulinClient

Run inside tomcat container
-----------------------------
Package it with maven

  - execute: *mvn clean package*
  - copy the result war file into your tomcat/webapp folder
  - Then open the URL: http://localhost:8080/InsulinClient
