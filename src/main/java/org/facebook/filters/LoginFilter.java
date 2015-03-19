package org.facebook.filters;

import org.facebook.util.HttpSessionHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GALIB on 3/11/2015.
 */

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI().substring(
                ((HttpServletRequest) servletRequest).getContextPath().length());

        if (requestedUri.contains("/views/resources/")) {
            filterChain.doFilter(servletRequest, servletResponse); // Goes to default servlet.
        }else{

            if (!HttpSessionHelper.isUserAuthenticated(request) && isRequestedPageForAuthenticatedUserOnly(requestedUri) ) {
                response.sendRedirect("login");
            } else if (HttpSessionHelper.isUserAuthenticated(request) && isRequestedPageForNotAuthenticatedUserOnly(requestedUri)) {
                response.sendRedirect("home");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    public static boolean isRequestedPageForAuthenticatedUserOnly(String requestedUri){
        return !requestedUri.contains("login") && !requestedUri.contains("signup");
    }

    public static boolean isRequestedPageForNotAuthenticatedUserOnly(String requestedUri){
        return requestedUri.contains("login") || requestedUri.contains("signup");
    }

    public void destroy() {
        //ignore
    }
}
