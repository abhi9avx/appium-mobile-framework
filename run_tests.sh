#!/bin/bash

for i in {1..10}
do
    echo "Running test iteration $i of 10"
    mvn test -DsuiteXmlFile=testng.xml
    echo "Completed iteration $i"
    echo "----------------------------------------"
done 