package org.facebook.controllers;

import org.facebook.models.Post;
import org.facebook.models.User;
import org.facebook.services.PostService;
import org.facebook.services.PostServiceImpl;
import org.facebook.util.HttpSessionHelper;

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
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private PostServiceImpl postService;

    @Override
    public void init() throws ServletException {
        super.init();
        postService = new PostServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = HttpSessionHelper.getAuthenticatedUser(request);

        List<Post> posts = postService.getNewsFeedPostsWithComments(user.getId());
        request.setAttribute("posts", posts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/pages/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
