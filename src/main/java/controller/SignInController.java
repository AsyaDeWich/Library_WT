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

@WebServlet(name = "controller.SignInController")
public class SignInController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/signIn.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String passwordHash = Hasher.SHA256(password);

        User user = UserService.authorization(login,passwordHash);
        if (user != null) {
            req.getSession().setAttribute("user", user);
        }

        if (user.role == User.Role.READER) {
            resp.sendRedirect("/mainreader");
        }
        else if (user.role == User.Role.LIBRARIAN) {
            resp.sendRedirect("/mainlibrarian<");
        }
        else resp.sendRedirect("/signin");
    }
}