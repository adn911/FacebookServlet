package org.facebook.dao;

import org.facebook.dao.mappers.PostRowMapper;
import org.facebook.models.Comment;
import org.facebook.models.Post;
import org.facebook.util.DatabaseTemplate;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class PostDAOImpl implements PostDAO {

    UserDAO userDAO;
    CommentDAO commentDAO;

    public PostDAOImpl() {
        commentDAO = new CommentDAOImpl();
        userDAO = new UserDAOImpl();
    }

    @Override
    public boolean insertPost(Post post) {
        String sql = "INSERT INTO posts (USER_ID,POST_TYPE,CONTENT,DATETIME) VALUES (?,?,?,?)";
        return DatabaseTemplate.executeQuery(sql, post.getUserId(), post.getType(), post.getContent(), post.getDateTime());
    }

    @Override
    public boolean updatePost(Post post) {
        String sql = "UPDATE posts SET POST_TYPE =?, CONTENT =?, DATETIME =? WHERE POST_ID =?";
        return DatabaseTemplate.executeQuery(sql, post.getType(), post.getContent(), post.getDateTime(), post.getId());
    }

    @Override
    public Post getPost(int postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts ORDER BY DATETIME DESC";
        List<Post> posts = DatabaseTemplate.queryForObject(sql, new PostRowMapper());
        return posts;
    }


    @Override
    public List<Post> getNewsFeedPosts(int currentUserId) {
        String sql = "SELECT * FROM posts WHERE USER_ID IN (SELECT FRIEND_ID FROM friends WHERE USER_ID =? ) OR USER_ID =? ORDER BY DATETIME DESC";
        List<Post> posts = DatabaseTemplate.queryForObject(sql, new PostRowMapper(), currentUserId, currentUserId);
        return posts;
    }

    @Override
    public List<Post> getNewsFeedPostsWithComments(int currentUserId) {
        String sql = "SELECT * FROM posts WHERE USER_ID IN (SELECT FRIEND_ID FROM friends WHERE USER_ID = ?) OR USER_ID = ? ORDER BY DATETIME DESC";
        List<Post> posts = DatabaseTemplate.queryForObject(sql, new PostRowMapper(), currentUserId, currentUserId);

        for(Post post:posts){
           post.setUser(userDAO.getUserInfo(post.getUserId()));
           List<Comment> comments = commentDAO.getPostComments(post.getId());

           for(Comment comment:comments){
              comment.setUser(userDAO.getUserInfo(comment.getUserId()));
           }
           post.setComments(comments);
        }
        return posts;
    }

    @Override
    public List<Post> getProfilePostsWithComments(int currentUserId) {
        List<Post> posts = getUserPosts(currentUserId);

        for(Post post:posts){
            post.setUser(userDAO.getUserInfo(post.getUserId()));
            List<Comment> comments = commentDAO.getPostComments(post.getId());

            for(Comment comment:comments){
                comment.setUser(userDAO.getUserInfo(comment.getUserId()));
            }
            post.setComments(comments);
        }
        return posts;
    }

    @Override
    public List<Post> getUserPosts(int userId) {
        String sql = "SELECT * FROM posts WHERE USER_ID =? ORDER BY DATETIME DESC";
        List<Post> posts = DatabaseTemplate.queryForObject(sql, new PostRowMapper(), userId);
        return posts;
    }

    @Override
    public boolean removeAll() {
        String sql = "DELETE FROM posts";
        return DatabaseTemplate.executeQuery(sql);
    }

    @Override
    public boolean removePost(int postId) {
        String sql = "DELETE FROM posts WHERE POST_ID =?";
        return DatabaseTemplate.executeQuery(sql, postId);
    }
}
