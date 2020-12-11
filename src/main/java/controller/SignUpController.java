package controller;

import beans.User;
import service.UserService;
import utils.Hasher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.SignUpController")
public class SignUpController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/signUp.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        String passwordHash = password.isEmpty() ? "" : Hasher.SHA256(password);

        User user = UserService.register(login,firstName,lastName,age,passwordHash);
        if (user != null) {
            req.getSession().setAttribute("user", user);
        }

        resp.sendRedirect("/signin");
    }
}