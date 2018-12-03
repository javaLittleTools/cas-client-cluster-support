package com.oc.domain;

/**
 * @author SxL
 * Created on 11/21/2018 3:28 PM.
 */
public class SessionMapping {

    private int id;

    private String mappingId;

    private String sessionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
