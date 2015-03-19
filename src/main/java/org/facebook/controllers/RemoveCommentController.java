package org.facebook.controllers;

import org.facebook.services.CommentService;
import org.facebook.services.CommentServiceImpl;
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
@WebServlet(name = "RemoveCommentController", urlPatterns = "/removeComment")
public class RemoveCommentController extends HttpServlet {

    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        super.init();
        commentService = new CommentServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commentId = NumberHelper.parseInteger(request.getParameter("commentId"));
        commentService.removeComment(commentId);
        response.sendRedirect("home");
    }
}
