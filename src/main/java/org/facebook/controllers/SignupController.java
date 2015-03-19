package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.UserService;
import org.facebook.services.UserServiceImpl;
import org.facebook.util.DateTimeHelper;
import org.facebook.util.FileUtils;
import org.facebook.util.SignupValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 3/9/15.
 */
@MultipartConfig
@WebServlet(name = "SignupControlller", urlPatterns = "/signup")
public class SignupController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Part profilePicturePart = request.getPart("profilePicture");
        String profilePicture = DateTimeHelper.getCurrentNanoTimeString() + ".jpg";
        String contextPath = request.getServletContext().getRealPath("");

        User user = SignupValidator.validate(username, firstName, lastName, email, password, dob, profilePicture);

        if (user != null) {
            FileUtils.writePartToFile(profilePicturePart, contextPath, profilePicture);

            if (userService.insertUser(user)) {
                response.sendRedirect("signup?success=1");
            } else {
                response.sendRedirect("signup?error=1");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/signup.jsp");
        requestDispatcher.forward(request, response);
    }
}
