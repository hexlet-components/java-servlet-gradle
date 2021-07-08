package io.hexlet;

import io.hexlet.servlet.GreetingServlet;
import io.hexlet.servlet.HelloWorldServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {

    public static void main(String[] args) throws LifecycleException {
        final var tomcat = new Tomcat();
        tomcat.setPort(8080);

        final var contextPath = "/";
        final var context = tomcat.addContext(contextPath, new File(".").getAbsolutePath());

        final var helloWorldServletName = "helloWorldServlet";
        tomcat.addServlet(contextPath, helloWorldServletName, new HelloWorldServlet());
        context.addServletMappingDecoded("/hello", helloWorldServletName);

        final var greetingServletName = "greetingServlet";
        tomcat.addServlet(contextPath, greetingServletName, new GreetingServlet());
        context.addServletMappingDecoded("/add", greetingServletName);

        tomcat.start();
        tomcat.getServer().await();
    }
}
