package org.facebook.controllers;

import org.facebook.services.PostService;
import org.facebook.services.PostServiceImpl;
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
@WebServlet(name = "RemovePostController", urlPatterns = "/removePost")
public class RemovePostController extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        super.init();
        postService = new PostServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        postService.removePost(NumberHelper.parseInteger(postId));
        response.sendRedirect("home");
    }
}
