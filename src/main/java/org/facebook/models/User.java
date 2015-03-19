package org.facebook.models;

import org.facebook.util.DateTimeHelper;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class User implements HttpSessionBindingListener {

    private int id;
    private String username;
    private String email;
    private String password;
    private boolean active;

    private String firstName;
    private String lastName;
    private String DOB;
    private String profilePicture;

    //user activities
    private List<Post> posts;
    private List<Comment> comments;
    private List<Like> likes;

    public static int numberOfLoggedInUsers = 0;

    public User(){}

    public User(int id, String username, String email, String password, boolean active, String firstName, String lastName, String DOB) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
    }

    public User(int id, String username, String email, String password, boolean active, String firstName, String lastName, String DOB, String profilePicture) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.profilePicture = profilePicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String toString(){
        String userString = "ID :"+ id +"\n"+"USERNAME :"+username+"\n"+"FIRSTNAME :"+firstName+"\n"+
                "LASTNAME :"+lastName+"\n"+"EMAIL :"+email+"\n"+"PASSWORD :"+password+"\n"+
                "DOB :"+DOB+"\n"+"STATUS :"+active+"\n";
        return userString;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        numberOfLoggedInUsers++;
        LoggerFactory.getLogger(User.class).info("USER "+username+" LOGGED IN AT "+ DateTimeHelper.getCurrentDateTimeString());
        LoggerFactory.getLogger(User.class).info("NUMBER OF LOGGED IN USERS "+numberOfLoggedInUsers);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        numberOfLoggedInUsers--;
        LoggerFactory.getLogger(User.class).info("USER "+username+" LOGGED OUT AT "+DateTimeHelper.getCurrentDateTimeString());
        LoggerFactory.getLogger(User.class).info("NUMBER OF LOGGED IN USERS "+numberOfLoggedInUsers);
    }
}
