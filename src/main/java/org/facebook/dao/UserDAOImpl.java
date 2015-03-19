package org.facebook.dao;

import org.facebook.dao.mappers.UserRowMapper;
import org.facebook.models.User;
import org.facebook.util.DatabaseTemplate;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {
        User user = null;
        String sql = "SELECT * FROM users WHERE EMAIl =? AND PASSWORD =?";
        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper(), loginEmail, loginPassword);
        return users.size() == 1 ? users.get(0) : null;
    }

    @Override
    public boolean insertUser(User user) {
        if(!userExists(user)){
            String sql = "INSERT INTO users (USER_NAME,EMAIL,PASSWORD,ACTIVE,FIRST_NAME,LAST_NAME,DOB,PROFILE_PICTURE) VALUES (?,?,?,?,?,?,?,?)";
            return DatabaseTemplate.executeQuery(sql, user.getUsername(), user.getEmail(), user.getPassword(), 1, user.getFirstName(), user.getLastName(), user.getDOB(),user.getProfilePicture());
        }else{
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET USER_NAME =?,EMAIL =?,PASSWORD =?,FIRST_NAME=?,LAST_NAME=?,DOB=?  WHERE USER_ID = ?";
        return DatabaseTemplate.executeQuery(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getDOB(), user.getId());
    }

    @Override
    public boolean removeUser(int userId) {
        String sql = "DELETE FROM users WHERE USER_ID =?";
        return DatabaseTemplate.executeQuery(sql, userId);
    }

    @Override
    public boolean removeUser(User user) {
        return this.removeUser(user.getId());
    }

    @Override
    public boolean deactivateUser(int userId) {
        String sql = "UPDATE users SET ACTIVE = 0 WHERE USER_ID =?";
        return DatabaseTemplate.executeQuery(sql, userId);
    }

    @Override
    public boolean deactivateUser(User user) {
        return this.deactivateUser(user.getId());
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper());
        return users;
    }

    @Override
    public boolean userExists(User user) {
        String sql = "SELECT * FROM users WHERE EMAIL = ? OR USER_NAME = ?";
        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper(),user.getEmail(),user.getUsername());
        return users.size() == 1;
    }

    @Override
    public User getUserInfo(int userId) {
        String sql = "SELECT * FROM users WHERE USER_ID =?";
        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public boolean removeAll() {
        String sql = "DELETE FROM users";
        return DatabaseTemplate.executeQuery(sql);
    }
}
