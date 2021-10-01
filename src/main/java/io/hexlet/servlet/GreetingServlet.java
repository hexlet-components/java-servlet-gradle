package io.hexlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final var body = """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8">
                    <title>Add</title>
                  </head>
                  <body>
                    <h1>%s</h1>
                  </body>
                </html>
                """;
        final var writer = resp.getWriter();
        Optional.ofNullable(req.getParameter("name"))
                .map(name -> "Your name is " + name)
                .map(body::formatted)
                .ifPresentOrElse(writer::println, () -> writer.println(body.formatted("What is your name?")));
    }
}
