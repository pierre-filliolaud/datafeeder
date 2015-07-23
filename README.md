# datafeeder
Engine to retrieve json data and store in Elastic Search database

# command to import in eclipse
mvn eclipse:clean eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true -Dwtpversion=2.0

# installation
- install elastic search on your machine
- run elastic search
- run datafeeder project

# command to run
mvn package
java -jar target/datafeeder-1.0-SNAPSHOT.jar
