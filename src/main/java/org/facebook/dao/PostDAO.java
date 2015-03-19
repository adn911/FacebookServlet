package org.facebook.dao;

import org.facebook.models.Post;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface PostDAO {

    public boolean insertPost(Post post);

    public boolean updatePost(Post post);

    public Post getPost(int postId);

    public List<Post> getAllPosts();

    public List<Post> getNewsFeedPosts(int currentUserId);

    List<Post> getNewsFeedPostsWithComments(int currentUserId);

    List<Post> getProfilePostsWithComments(int currentUserId);

    public List<Post> getUserPosts(int userId);

    public boolean removeAll();

    public boolean removePost(int postId);

}
