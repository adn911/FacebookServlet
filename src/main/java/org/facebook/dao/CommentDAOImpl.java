package org.facebook.dao;

import org.facebook.dao.mappers.CommentRowMapper;
import org.facebook.models.Comment;
import org.facebook.util.DatabaseTemplate;

import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class CommentDAOImpl implements CommentDAO {

    public CommentDAOImpl() {
    }

    @Override
    public boolean insertComment(Comment comment) {
        String sql = "INSERT INTO comments (USER_ID,POST_ID,CONTENT,DATETIME) VALUES (?,?,?,?)";
        return DatabaseTemplate.executeQuery(sql, comment.getUserId(), comment.getPostId(),
                comment.getContent(), comment.getDateTime());
    }

    @Override
    public boolean updateComment(Comment updatedComment) {
        String sql = "UPDATE comments SET CONTENT =?,DATETIME =? WHERE COMMENT_ID =?";
        return DatabaseTemplate.executeQuery(sql, updatedComment.getContent(), updatedComment.getDateTime(), updatedComment.getId());
    }


    @Override
    public List<Comment> getPostComments(int postId) {
        String sql = "SELECT * FROM comments WHERE POST_ID =?";
        List<Comment> comments = DatabaseTemplate.queryForObject(sql, new CommentRowMapper(), postId);
        return comments;
    }

    @Override
    public List<Comment> getUserComments(int userId) {
        String sql = "SELECT * FROM comments WHERE USER_ID = ?";
        List<Comment> comments = DatabaseTemplate.queryForObject(sql, new CommentRowMapper(), userId);
        return comments;
    }

    @Override
    public boolean removeAll() {
        String sql = "DELETE FROM comments";
        return DatabaseTemplate.executeQuery(sql);
    }

    @Override
    public boolean removeComment(int commentId) {
        String sql = "DELETE FROM comments WHERE COMMENT_ID =?";
        return DatabaseTemplate.executeQuery(sql, commentId);
    }

    @Override
    public boolean removeComment(Comment comment) {
        return this.removeComment(comment);
    }

}
