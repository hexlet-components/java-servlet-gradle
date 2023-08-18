// package io.hexlet;
//
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.Test;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import org.apache.catalina.startup.Tomcat;
// import org.apache.catalina.LifecycleException;
// import kong.unirest.HttpResponse;
// import kong.unirest.Unirest;
//
// class AppTest {
//
//     private static Tomcat app;
//     private static String baseUrl;
//
//     @BeforeAll
//     public static void beforeAll() throws LifecycleException {
//         app = App.getApp(0);
//         app.start();
//         int port = app.getConnector().getLocalPort();
//         String hostname = app.getHost().getName();
//         String scheme = app.getConnector().getScheme();
//         baseUrl = scheme + "://" + hostname + ":" + port;
//     }
//
//     @AfterAll
//     public static void afterAll() throws LifecycleException {
//         app.stop();
//     }
//
//     @Test
//     void testHelloWorld() {
//         HttpResponse<String> response = Unirest
//             .get(baseUrl)
//             .asString();
//         assertThat(response.getStatus()).isEqualTo(200);
//         assertThat(response.getBody()).contains("Hello World");
//     }
//
//     @Test
//     void testGreetingWithoutName() {
//         HttpResponse<String> response = Unirest
//             .get(baseUrl + "/greeting")
//             .asString();
//         assertThat(response.getStatus()).isEqualTo(200);
//         assertThat(response.getBody()).contains("What is your name?");
//     }
//
//     @Test
//     void testGreetingWithName() {
//         HttpResponse<String> response = Unirest
//             .get(baseUrl + "/greeting")
//             .queryString("name", "Tirion")
//             .asString();
//         assertThat(response.getStatus()).isEqualTo(200);
//         assertThat(response.getBody()).contains("Your name is Tirion");
//     }
// }
