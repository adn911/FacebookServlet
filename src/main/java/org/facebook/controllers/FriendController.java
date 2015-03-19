package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.FriendService;
import org.facebook.services.FriendServiceImpl;
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
@WebServlet(name = "FriendController", urlPatterns = {"/friends"})
public class FriendController extends HttpServlet {

    private FriendService friendService;

    @Override
    public void init() throws ServletException {
        super.init();
        friendService = new FriendServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = HttpSessionHelper.getAuthenticatedUser(request);
        request.setAttribute("friends", friendService.getFriends(user.getId()));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/friends.jsp");
        requestDispatcher.forward(request, response);
    }
}
