package org.facebook.services;

import org.facebook.dao.CommentDAO;
import org.facebook.dao.CommentDAOImpl;
import org.facebook.models.Comment;

import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    public CommentServiceImpl() {
        this.commentDAO = new CommentDAOImpl();
    }

    @Override
    public boolean insertComment(Comment comment) {
        return commentDAO.insertComment(comment);
    }

    @Override
    public boolean updateComment(Comment updatedComment) {
        return commentDAO.updateComment(updatedComment);
    }

    @Override
    public List<Comment> getPostComments(int postId) {
       return commentDAO.getPostComments(postId);
    }

    @Override
    public List<Comment> getUserComments(int userId) {
        return commentDAO.getUserComments(userId);
    }

    @Override
    public boolean removeAll() {
        return commentDAO.removeAll();
    }

    @Override
    public boolean removeComment(int commentId) {
        return commentDAO.removeComment(commentId);
    }
}
