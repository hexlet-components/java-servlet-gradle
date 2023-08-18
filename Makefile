setup:
	gradle wrapper --gradle-version 8.3

install:
	./gradlew install

clean:
	./gradlew clean

build:
	./gradlew build

start-dist:
	./build/install/java-servlet-gradle/bin/java-servlet-gradle

dev:
	./gradlew appRun

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

check-deps:
	./gradlew dependencyUpdates

.PHONY: build
