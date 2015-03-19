package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.UserService;
import org.facebook.services.UserServiceImpl;
import org.facebook.util.HttpSessionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 3/11/15.
 */

@WebServlet(name = "UpdateInfoController", urlPatterns = "/updateInfo")
public class UpdateInfoController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserInfo(HttpSessionHelper.getAuthenticatedUser(request).getId());
        user.setUsername(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setDOB(dob);

        if (userService.updateUser(user)) {
            HttpSessionHelper.setAuthenticatedUser(request, user);
            response.sendRedirect("updateInfo?success=1");
        } else {
            response.sendRedirect("updateInfo?error=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = HttpSessionHelper.getAuthenticatedUser(request);
        request.setAttribute("user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/updateInfo.jsp");
        requestDispatcher.forward(request, response);
    }
}
