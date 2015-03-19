package org.facebook.util;

import org.facebook.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by bakhtiar.galib on 3/12/15.
 */
public class HttpSessionHelper {

    public static HttpSession getCurrentSession(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession();
    }

    public static User getAuthenticatedUser(HttpServletRequest httpServletRequest) {
        return (User) getCurrentSession(httpServletRequest).getAttribute("user");
    }

    public static void setAuthenticatedUser(HttpServletRequest httpServletRequest, User user) {
        getCurrentSession(httpServletRequest).setAttribute("user", user);
    }

    public static boolean isUserAuthenticated(HttpServletRequest httpServletRequest){
         return getAuthenticatedUser(httpServletRequest) != null;
    }

    public static void destroyCurrentSession(HttpServletRequest httpServletRequest) {
        getCurrentSession(httpServletRequest).invalidate();
    }
}
