
========
This repository contains all code and configurations for the stack overflow question found http://stackoverflow.com/questions/30920475/how-can-i-support-cross-store-persistence-on-a-partial-nodeentity-between-neo4j

#build
Build the project using gradle, I have included a gradle wrapper in the project.
./gradlew build

#Modify configs
Modify the following files to include the postgres database, username and password as well as your neo4j username and password
* rest/src/main/resources/config/application.yml
* rest/src/main/com/rest/src/main/com/Neo4jConfig.java

#Run
##Before you run the spring boot app
* Start your neo4j database
* Start your postgres database

cd rest
./../gradlew bootRun

#Test
localhost:8080/users/test
