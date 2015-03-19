package org.facebook.dao;

import org.facebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface UserDAO {

    public User loginUser(String email, String password);

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    boolean deactivateUser(User user);

    public List<User> getAllUsers();

    boolean userExists(User user);

    public User getUserInfo(int userId);

    boolean removeUser(User user);

    public boolean deactivateUser(int userId);

    public boolean removeUser(int userId);

    public boolean removeAll();
}
