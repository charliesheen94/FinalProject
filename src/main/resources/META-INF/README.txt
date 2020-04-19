Windows Instructions
Create Folder Called "JAR" in C:/ Drive
Open JAR FOLER in C:/JAR/ and paste volt-theme-2.0.1.jar into JAR Folder
Open CMD and Paste COmmand below and run
then proceed to IntelliJ 

MAC instructions
Mac might be different but the command is the same place the Jar into a Folder
Then replace that folder path with the path that the jar file is in.
update the command below with the new path and run in the terminal.
You will need to exit IntelliJ after installing the theme and reopen intelliJ for libraries to become active.


mvn install:install-file -Dfile=C:\JAR\volt-theme-2.0.1.jar -DgroupId=org.primefaces -DartifactId=volt-theme -Dversion=2.0.1 -Dpackaging=jar
