package io.hexlet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kong.unirest.core.Unirest;

class AppTest {
    static String baseUrl;

    @BeforeAll
    static void setup() {
        baseUrl = System.getProperty("gretty.httpBaseURI");
    }

    @Test
    void testMainPage() {
        var response = Unirest.get(baseUrl).asString();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getBody()).contains("users");
    }

    @Test
    void testAboutPage() {
        var response = Unirest.get(baseUrl + "/about").asString();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getBody()).contains("Jakarta");
    }

    @Test
    void testUsersPage() {
        var response = Unirest.get(baseUrl + "/users").asString();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getBody()).contains("Nina");
    }
}
