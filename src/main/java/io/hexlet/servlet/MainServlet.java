package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "MainServlet", urlPatterns = "/about")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TEST!");
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h2>Hello from MyServlet using Jakarta Servlet API!</h2>");
        writer.println("</body></html>");
    }
}
