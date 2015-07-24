datafeeder
==========
Spring Batch/Spring Data implementation to inject data in ElasticSearch.

This Engine retrieves json data and store in Elastic Search database

Eclipse commands
----------------
mvn eclipse:clean eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true -Dwtpversion=2.0

Installation
------------
- install elastic search on your machine with node name: elasticsearch
- run elastic search
- run datafeeder project

Run commands
------------
mvn package
java -jar target/datafeeder-1.0-SNAPSHOT.jar
