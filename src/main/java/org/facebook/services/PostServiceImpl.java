package org.facebook.services;

import org.facebook.dao.PostDAO;
import org.facebook.dao.PostDAOImpl;
import org.facebook.models.Post;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class PostServiceImpl implements PostService {

    PostDAO postDao;

    public PostServiceImpl() {
        postDao = new PostDAOImpl();
    }

    @Override
    public boolean insertPost(Post post) {
       return postDao.insertPost(post);
    }

    @Override
    public boolean updatePost(Post post) {
     return postDao.updatePost(post);
    }

    @Override
    public Post getPost(int postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }


    @Override
    public List<Post> getNewsFeedPosts(int currentUserId) {
       return postDao.getNewsFeedPosts(currentUserId);
    }

    @Override
    public List<Post> getNewsFeedPostsWithComments(int currentUserId) {
        return postDao.getNewsFeedPostsWithComments(currentUserId);
    }

    @Override
    public List<Post> getProfilePostsWithComments(int currentUserId) { return postDao.getProfilePostsWithComments(currentUserId);}

    @Override
    public List<Post> getUserPosts(int userId) {
       return postDao.getUserPosts(userId);
    }

    @Override
    public boolean removeAll() {
       return postDao.removeAll();
    }

    @Override
    public boolean removePost(int postId) {
      return postDao.removePost(postId);
    }
}
