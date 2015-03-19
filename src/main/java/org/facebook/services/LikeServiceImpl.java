package org.facebook.services;

import org.facebook.dao.LikeDAO;
import org.facebook.dao.LikeDAOImpl;
import org.facebook.models.Like;
import org.facebook.models.User;

import java.util.List;

/**
 * Created by GALIB on 2/8/2015.
 */
public class LikeServiceImpl implements LikeService {

    private LikeDAO likeDAO;

    public LikeServiceImpl() {
        this.likeDAO = new LikeDAOImpl();
    }

    @Override
    public boolean addLike(Like like) {

        return likeDAO.addLike(like);
    }

    @Override
    public boolean removeLike(int likeId) {

       return likeDAO.removeLike(likeId);
    }

    @Override
    public List<User> getLikedUsers(int postId) {

       return this.likeDAO.getLikedUsers(postId);
    }

    @Override
    public int getLikeCount(int postId) {

       return this.likeDAO.getLikeCount(postId);
    }
}
