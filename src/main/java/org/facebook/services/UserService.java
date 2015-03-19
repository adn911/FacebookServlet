package org.facebook.services;

import org.facebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface UserService {

    public User loginUser(String email, String password);
    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public List<User> getAllUsers();
    public User getUserInfo(int userId);


    public boolean deactivateUser(int userId);
    public boolean removeUser(int userId);
    public boolean removeAll();
}
