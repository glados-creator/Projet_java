clear
javac -d bin/ \
--module-path /usr/share/openjfx/lib/ \
--add-modules javafx.controls \
./projet_java/src/main/java/olympic/*.java \
./projet_java/src/main/java/olympic/model/*.java \
./projet_java/src/main/java/olympic/graphic/*.java \
./projet_java/src/main/java/olympic/graphic/GUI_admin/*.java \
./projet_java/src/main/java/olympic/graphic/GUI_organistateur/*.java \
./projet_java/src/main/java/olympic/graphic/GUI_presentateur/*.java &&
java -ea -cp bin:bin/olympic/:bin/olympic/model/:bin/olympic/graphic:bin/olympic/graphic/GUI_admin:bin/olympic/graphic/GUI_organistateur:bin/olympic/graphic/GUI_presentateur:/usr/share/java/mariadb-java-client.jar --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls olympic.App