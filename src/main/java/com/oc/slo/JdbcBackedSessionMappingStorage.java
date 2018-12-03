package com.oc.slo;

import com.oc.dao.SessionMappingMapper;
import com.oc.domain.SessionMapping;
import com.oc.listener.CustomSessionListener;
import org.jasig.cas.client.session.SessionMappingStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author SxL
 * Created on 11/18/2018 16:49.
 */
@Component
public class JdbcBackedSessionMappingStorage implements SessionMappingStorage {

    private final SessionMappingMapper sessionMappingMapper;

    @Autowired
    public JdbcBackedSessionMappingStorage(SessionMappingMapper sessionMappingMapper) {
        this.sessionMappingMapper = sessionMappingMapper;
    }

    @Override
    public HttpSession removeSessionByMappingId(String mappingId) {
        HttpSession session;

        SessionMapping sessionMapping = sessionMappingMapper.selectById(mappingId);
        String sessionId = sessionMapping.getSessionId();
        session = CustomSessionListener.sessionPool.get(sessionMapping.getSessionId());

        if (session != null) {
            removeBySessionById(sessionId);

        }

        return session;
    }

    @Override
    public void removeBySessionById(String sessionId) {
        sessionMappingMapper.deleteById(sessionId);
    }

    @Override
    public void addSessionById(String mappingId, HttpSession session) {
        SessionMapping sessionMapping = new SessionMapping();

        sessionMapping.setMappingId(mappingId);
        sessionMapping.setSessionId(session.getId());
        sessionMappingMapper.insertSelective(sessionMapping);
    }
}