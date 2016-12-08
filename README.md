# Data import from CSV files

## Build 

Maven is used for building and installation of the project.
If maven is not available, maven wrapper is provided (mvnw) 
in the root folder of the project.
To build and install use chese commands

mvn clean install 

or
./mvnw clean install

## Run

java -jar target/data-importer-1.0.0-SNAPSHOT.jar --files="./src/test/resources/servoata.csv"

Note:   Change 1.0.0-SNAPSHOT with your concrete release version
        List all your files as a comma delimited string in quotes