package controller;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by simon on 10/12/15.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else if(action.equals("dologin")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            request.setAttribute("email", email);
            request.setAttribute("password", password);


            User user = new User(email, password);

            if(user.validate()) {
                request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
            }
            else {
                request.setAttribute("validationMessage", user.getMessage());
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else if(action.equals("login")){

            request.setAttribute("email", "");
            request.setAttribute("password", "");
            request.setAttribute("validationMessage", "");

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
