package org.facebook.services;

import org.facebook.dao.UserDAO;
import org.facebook.dao.UserDAOImpl;
import org.facebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {
        return userDAO.loginUser(loginEmail, loginPassword);
    }

    @Override
    public boolean insertUser(User user) {
      return userDAO.insertUser(user);
    }

    @Override
    public boolean updateUser(User user){
      return userDAO.updateUser(user);
    }

    @Override
    public boolean removeUser(int userId) {
        return userDAO.removeUser(userId);
    }

    @Override
    public boolean deactivateUser(int userId) {
        return userDAO.deactivateUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserInfo(int userId) {
       return userDAO.getUserInfo(userId);
    }

    @Override
    public boolean removeAll() {
       return userDAO.removeAll();
    }
}
