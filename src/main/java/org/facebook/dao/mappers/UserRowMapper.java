package org.facebook.dao.mappers;



import org.facebook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class UserRowMapper implements ObjectRowMapper<User> {

    @Override
    public User mapRowToObject(ResultSet rs) throws SQLException {
        int id  = rs.getInt("USER_ID");
        String username = rs.getString("USER_NAME");
        String email = rs.getString("EMAIL");
        String password = rs.getString("PASSWORD");
        boolean active = rs.getBoolean("ACTIVE");

        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");
        String DOB = rs.getString("DOB");
        String profilePicture = rs.getString("PROFILE_PICTURE");

        return new User(id,username,email,password,active,firstName,lastName,DOB,profilePicture);
    }



}
