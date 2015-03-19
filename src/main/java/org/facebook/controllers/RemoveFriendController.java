package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.FriendService;
import org.facebook.services.FriendServiceImpl;
import org.facebook.util.HttpSessionHelper;
import org.facebook.util.NumberHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 3/11/15.
 */
@WebServlet(name = "RemoveFriendController", urlPatterns = "/removeFriend")
public class RemoveFriendController extends HttpServlet {

    private FriendService friendService;

    @Override
    public void init() throws ServletException {
        super.init();
        friendService = new FriendServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("removeFriendSubmit") != null) {
            User user = HttpSessionHelper.getAuthenticatedUser(request);
            String friendId = request.getParameter("userId");

            friendService.removeFriend(user.getId(), NumberHelper.parseInteger(friendId));
            response.sendRedirect("friends");
        }
    }
}
