if not exist bin\nul md bin
javac -d bin src\Patient.java src\Container.java src\Task3.java 
java -classpath bin Task3