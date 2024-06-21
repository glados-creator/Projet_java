clear
javac -d ./bin -classpath "lib/hamcrest-2.2.jar;lib/jacocoagent.jar;lib/jacococli.jar;lib/junit-4.13.2.jar;lib/junit-jupiter-api-5.3.2.jar;lib/junit-jupiter-engine-5.3.2.jar;lib/junit-platform-console-1.3.2.jar;lib/junit-platform-console-standalone-1.3.2.jar;lib/mysql-connector-j-8.3.0.jar;lib/mysql-connector-java-5.1.44.jar" \
./projet_java/src/main/java/olympic/*.java \
./projet_java/src/main/java/olympic/JDBC/*.java \
./projet_java/src/main/java/olympic/model/*.java \
./projet_java/src/main/java/olympic/model/sport_type/*.java \
./projet_java/src/main/java/olympic/graphic/*.java
java -javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp "./bin;lib/*" org.junit.platform.console.ConsoleLauncher --class-path "./bin" --scan-class-path --include-classname ".*test.*"
java -jar lib/jacococli.jar report jacoco.exec --classfiles bin --sourcefiles src --html report