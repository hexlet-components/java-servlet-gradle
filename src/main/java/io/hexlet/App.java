package io.hexlet;

import io.hexlet.servlet.GreetingServlet;
import io.hexlet.servlet.HelloWorldServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

import java.io.File;

public class App {

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "8080");
        return Integer.valueOf(port);
    }

    public static Tomcat getApp(int port) {
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(port);

        Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());

        tomcat.addServlet(ctx, HelloWorldServlet.class.getSimpleName(), new HelloWorldServlet());
        ctx.addServletMappingDecoded("", HelloWorldServlet.class.getSimpleName());

        tomcat.addServlet(ctx, GreetingServlet.class.getSimpleName(), new GreetingServlet());
        ctx.addServletMappingDecoded("/greeting", GreetingServlet.class.getSimpleName());

        return tomcat;
    }

    public static void main(String[] args) throws LifecycleException {
        int port = getPort();
        Tomcat app = getApp(port);
        app.start();
        app.getServer().await();
    }
}
