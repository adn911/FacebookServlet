package org.facebook.controllers;

import org.facebook.models.User;
import org.facebook.services.FriendService;
import org.facebook.services.FriendServiceImpl;
import org.facebook.util.HttpSessionHelper;
import org.facebook.util.NumberHelper;

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
@WebServlet(name = "AddFriendController", urlPatterns = "/addFriend")
public class AddFriendController extends HttpServlet {

    private FriendService friendService;

    @Override
    public void init() throws ServletException {
        super.init();
        friendService = new FriendServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addFriendSubmit") != null) {
            String friendId = request.getParameter("userId");
            User user = HttpSessionHelper.getAuthenticatedUser(request);

            friendService.addFriend(user.getId(), NumberHelper.parseInteger(friendId));
            response.sendRedirect("addFriend?success=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = HttpSessionHelper.getAuthenticatedUser(request);
        FriendService friendService = new FriendServiceImpl();

        request.setAttribute("usersNotFriends", friendService.getUsersNotFriend(user.getId()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/addFriend.jsp");
        requestDispatcher.forward(request, response);
    }
}
