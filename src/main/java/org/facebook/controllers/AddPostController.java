package org.facebook.controllers;

import org.facebook.models.Post;
import org.facebook.models.User;
import org.facebook.services.PostService;
import org.facebook.services.PostServiceImpl;
import org.facebook.util.DateTimeHelper;
import org.facebook.util.HttpSessionHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bakhtiar.galib on 3/11/15.
 */
@WebServlet(name = "AddPostController", urlPatterns = "/addPost")
public class AddPostController extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        super.init();
        postService = new PostServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("postSubmit") != null) {
            User user = HttpSessionHelper.getAuthenticatedUser(request);
            String content = request.getParameter("postContent");

            Post post = new Post();
            post.setUserId(user.getId());
            post.setType(1);
            post.setContent(content);
            post.setDateTime(DateTimeHelper.getCurrentDateTimeString());

            postService.insertPost(post);

            response.sendRedirect("home");
        }
    }
}
