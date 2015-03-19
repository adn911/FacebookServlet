package org.facebook.controllers;

import org.facebook.models.Post;
import org.facebook.services.PostService;
import org.facebook.services.PostServiceImpl;
import org.facebook.util.HttpSessionHelper;
import org.facebook.util.NumberHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by bakhtiar.galib on 3/9/15.
 */
@WebServlet(name = "ProfileController", urlPatterns = "/profile")
public class ProfileController extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        super.init();
        postService = new PostServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userId");
        int userId = (id == null ? HttpSessionHelper.getAuthenticatedUser(request).getId() : NumberHelper.parseInteger(id));

        List<Post> posts = postService.getProfilePostsWithComments(userId);
        request.setAttribute("posts", posts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/profile.jsp");
        requestDispatcher.forward(request, response);
    }
}
