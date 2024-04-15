#!/bin/bash
clear
mkdir bin 
echo "compiling" 
cd ./bin/ 
javac -d "./" ../projet_java/src/main/java/olympic/*.java ../projet_java/src/main/java/olympic/model/*.java &&
cd .. 
echo "" 
mkdir doc 
echo "doc" 
javadoc -d doc/ -charset utf8 -private -noqualifier all ./projet_java/src/main/java/olympic/*.java ./projet_java/src/main/java/olympic/model/*.java &&
echo "" 
echo "running" 
cd ./bin/ 
echo "" 
java -ea olympic.App
cd ..