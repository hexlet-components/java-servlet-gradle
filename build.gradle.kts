import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    id("war")
    id("org.gretty") version "4.1.6"
    id("checkstyle")
    id("io.freefair.lombok") version "8.13.1"
    id("com.github.ben-manes.versions") version "0.52.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.hexlet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.2")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

    implementation("org.slf4j:slf4j-simple:2.0.17")

    implementation("org.zalando:logbook-core:3.11.0")
    implementation("org.zalando:logbook-servlet:3.11.0")

    testImplementation("com.konghq:unirest-java-core:4.4.5")
    testImplementation("com.konghq:unirest-java-bom:4.4.5")

    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation(platform("org.junit:junit-bom:5.12.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

gretty {
    integrationTestTask = "test"
    contextPath = '/'
    servletContainer = "tomcat10"
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}
