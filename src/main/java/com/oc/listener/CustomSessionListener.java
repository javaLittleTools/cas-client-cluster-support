package com.oc.listener;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

/**
 * @author SxL
 * Created on 11/21/2018 3:11 PM.
 */
public class CustomSessionListener implements HttpSessionListener {

    public static Map<String, HttpSession> sessionPool = Maps.newHashMap();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionPool.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionPool.remove(se.getSession().getId());
    }
}
