package org.facebook.services;

import org.facebook.models.Comment;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface CommentService {

    public boolean insertComment(Comment comment);
    public boolean updateComment(Comment updatedComment);
    public List<Comment> getPostComments(int postId);
    public List<Comment>  getUserComments(int userId);
    public boolean removeAll();
    public boolean removeComment(int commentId);

}
