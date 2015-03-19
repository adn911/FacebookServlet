package org.facebook.models;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class Comment {

    private int id;
    private int userId;
    private int postId;
    private String content;
    private String dateTime;

    private Post post;
    private User user;


    public Comment(){}

    public Comment(int id, int postId, int userId, String content, String dateTime) {
        this.postId = postId;
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String toString(){

        String commentString = "ID :"+id+"\n"+"USER_ID :"+userId+"\n"+"POST_ID :"+postId+"\n"+
                "CONTENT :"+content+"\n"+"COMMENT_DATETIME :"+dateTime+"\n";

        return commentString;
    }
}
