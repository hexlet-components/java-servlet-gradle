setup:
	./gradlew install

start-dist:
	./build/install/java-servlet-gradle/bin/java-servlet-gradle

start:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest
