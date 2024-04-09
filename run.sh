clear
javac -d ./bin/ ./projet_java/src/main/java/olympic/*.java ./projet_java/src/main/java/olympic/model/*.java &&
java -ea -cp ./bin/olympic/:./bin/olympic/model/ olympic.App