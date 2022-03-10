FROM gradle:7.4.0-jdk17

WORKDIR /app

COPY . .

RUN gradle installDist

CMD build/install/java-servlet-gradle/bin/java-servlet-gradle
