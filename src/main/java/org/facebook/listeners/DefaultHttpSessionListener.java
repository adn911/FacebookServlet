package org.facebook.listeners;

import org.facebook.util.DateTimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Created by GALIB on 3/12/2015.
 */
@WebListener
public class DefaultHttpSessionListener implements HttpSessionListener {

    private final static Logger logger= LoggerFactory.getLogger(DefaultHttpSessionListener.class);
    private static int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessionCount++;
        HttpSession httpSession = httpSessionEvent.getSession();
        String sessionId = httpSession.getId();
        logger.info("NEW SESSION CREATED WITH SESSION ID "+sessionId+" AT "+DateTimeHelper.getCurrentDateTimeString());
        logger.info("SESSION COUNT "+sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionCount--;
        HttpSession httpSession = httpSessionEvent.getSession();
        String sessionId = httpSession.getId();
        logger.info("SESSION ID: "+sessionId+" DESTROYED AT "+DateTimeHelper.getCurrentDateTimeString() );
        logger.info("SESSION COUNT "+sessionCount);
    }
}
