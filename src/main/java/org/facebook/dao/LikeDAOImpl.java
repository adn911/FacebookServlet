package org.facebook.dao;

import org.facebook.dao.mappers.LikeRowMapper;
import org.facebook.models.Like;
import org.facebook.models.User;
import org.facebook.util.DatabaseTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GALIB on 2/8/2015.
 */
public class LikeDAOImpl implements LikeDAO {

    public LikeDAOImpl() {
    }

    @Override
    public boolean addLike(Like like) {
        String sql = "INSERT INTO likes (POST_ID,USER_ID,ACTIVE,DATETIME) VALUES (?,?,?,?)";
        return DatabaseTemplate.executeQuery(sql, like.getPostId(), like.getUserId(), like.isActive(), like.getDateTime());
    }

    @Override
    public boolean removeLike(int likeId) {
        String sql = "UPDATE likes SET active = 0 WHERE LIKE_ID =?";
        return DatabaseTemplate.executeQuery(sql, likeId);
    }

    @Override
    public List<User> getLikedUsers(int postId) {
        List<User> likedUsers = new ArrayList<User>();
        UserDAO userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM likes WHERE POST_ID =?";
        List<Like> likes = DatabaseTemplate.queryForObject(sql, new LikeRowMapper(), postId);

        for (Like like : likes) {
            int userId = like.getUserId();
            likedUsers.add(userDAO.getUserInfo(userId));
        }
        return likedUsers;
    }

    @Override
    public int getLikeCount(int postId) {
        String sql = "SELECT * FROM likes WHERE POST_ID =?";
        List<Like> likes = DatabaseTemplate.queryForObject(sql, new LikeRowMapper(), postId);
        return likes.size();
    }
}
