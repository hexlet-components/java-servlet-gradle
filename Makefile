install:
	./gradlew install

clean:
	./gradlew clean

start-dist:
	./build/install/java-servlet-gradle/bin/java-servlet-gradle

start:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

.PHONY: build
