package org.facebook.controllers;

import org.facebook.models.Comment;
import org.facebook.models.User;
import org.facebook.services.CommentService;
import org.facebook.services.CommentServiceImpl;
import org.facebook.util.DateTimeHelper;
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
@WebServlet(name = "AddCommentController", urlPatterns = "/addComment")
public class AddCommentController extends HttpServlet {

    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        super.init();
        commentService = new CommentServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("commentSubmit") != null) {
            User user = HttpSessionHelper.getAuthenticatedUser(request);
            String postId = request.getParameter("postId");
            String content = request.getParameter("commentContent");

            Comment comment = new Comment();
            comment.setUserId(user.getId());
            comment.setPostId(NumberHelper.parseInteger(postId));
            comment.setContent(content);
            comment.setDateTime(DateTimeHelper.getCurrentDateTimeString());

            commentService.insertComment(comment);

            response.sendRedirect("home");
        }
    }
}
