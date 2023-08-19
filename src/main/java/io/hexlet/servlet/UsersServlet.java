package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Hello from Jakarta Servlet!";
        String[] users = {"Mike", "Nina"};
        req.setAttribute("message", message);
        req.setAttribute("users", users);

        req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
    }
}
