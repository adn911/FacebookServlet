package org.facebook.services;

import org.facebook.dao.FriendDAO;
import org.facebook.dao.FriendDAOImpl;
import org.facebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class FriendServiceImpl implements FriendService {

    private FriendDAO friendDAO;

    public FriendServiceImpl() {
      this.friendDAO = new FriendDAOImpl();
    }

    public List<User> getUsersNotFriend(int userId) {

       return friendDAO.getUsersNotFriend(userId);
    }

    @Override
    public List<User> getFriends(int userId) {

      return friendDAO.getFriends(userId);
    }

    @Override
    public boolean addFriend(int userId, int friendId) {

      return friendDAO.addFriend(userId,friendId);
    }

    @Override
    public boolean removeFriend(int userId,int friendId) {

      return friendDAO.removeFriend(userId,friendId);
    }

}
