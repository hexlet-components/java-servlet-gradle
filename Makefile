install:
	./gradlew install

clean:
	./gradlew clean

build:
	./gradlew build

start-dist:
	./build/install/java-servlet-gradle/bin/java-servlet-gradle

start:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

check-updates:
	./gradlew dependencyUpdates

.PHONY: build
