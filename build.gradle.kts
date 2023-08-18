plugins {
    id("java")
    id("war")
    id("org.gretty") version "4.1.0"
    id("checkstyle")
    id("io.freefair.lombok") version "8.2.2"
    id("com.github.ben-manes.versions") version "0.47.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.hexlet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    // implementation("ch.qos.logback:logback-access:1.4.11")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("org.slf4j:slf4j-simple:2.0.7")

    implementation("org.zalando:logbook-core:3.3.0")
    implementation("org.zalando:logbook-servlet:3.3.0")

    // testImplementation(platform("org.junit:junit-bom:5.10.0"))
    // testImplementation("org.junit.jupiter:junit-jupiter")
}

gretty {
    // servletContainer = "jetty9"
    // httpsEnabled = true
    // managedClassReload = true
    contextPath = '/'
    // loggingLevel = ""
    // managedClassReload = true
    // loggingLevel = 'ALL'
    // debug = true
}
