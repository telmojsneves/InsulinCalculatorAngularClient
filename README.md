Insulin Client
====================

#Pre Conditions
mvn installed (version 3)

#Install

do this commands inside project folder

mvn install:install-file -Dfile=lib/WSservicesQCSID04.jar -DgroupId=dei.qcs.g04 -DartifactId=ws04 -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/WSservicesQCSID02.jar -DgroupId=dei.qcs.g02 -DartifactId=ws02 -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/WSservicesQCSID03.jar -DgroupId=dei.qcs.g03 -DartifactId=ws03 -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/WSservicesQCS05.jar -DgroupId=dei.qcs.g05 -DartifactId=ws05 -Dversion=1.0 -Dpackaging=jar

mvn install:install-file -Dfile=lib/WSservicesQCS07.jar -DgroupId=dei.qcs.g07 -DartifactId=ws07 -Dversion=1.0 -Dpackaging=jar

and remember to add this in libraries to work


Run Local (Embedded Tomcat):
----------------
  - execute: *mvn tomcat7:run*
  - Then open the URL: http://localhost:8080/InsulinCalculator

Web link:
----------------
http://10.17.0.115:8080/InsulinCalculator/#/midp

Run inside tomcat container
-----------------------------
Package it with maven

  - execute: *mvn clean package*
  - copy the result war file into your tomcat/webapp folder
  - Then open the URL: http://localhost:8080/InsulinCalculator
