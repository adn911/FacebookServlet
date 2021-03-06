package org.facebook.dao;

import org.facebook.models.Like;
import org.facebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface LikeDAO {

    public boolean addLike(Like like);

    public boolean removeLike(int likeId);

    public List<User> getLikedUsers(int postId);

    public int getLikeCount(int postId);

}
