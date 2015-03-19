package org.facebook.dao.mappers;



import org.facebook.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class PostRowMapper implements ObjectRowMapper<Post> {

    @Override
    public Post mapRowToObject(ResultSet rs) throws SQLException {
        int id  = rs.getInt("POST_ID");
        int userId  = rs.getInt("USER_ID");
        int type = rs.getInt("POST_TYPE");
        String content = rs.getString("CONTENT");
        String dateTime = removeMillisFromDateTime(rs.getString("DATETIME"));
        return new Post(id,userId, type, content, dateTime);
    }

    private String removeMillisFromDateTime(String dateTime) {
        return dateTime != null? dateTime.split("\\.")[0]:dateTime;
    }


}
