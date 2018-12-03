package com.oc.dao;

import com.oc.domain.SessionMapping;

/**
 * @author SxL
 * Created on 11/21/2018 3:30 PM.
 */
public interface SessionMappingMapper {

    int insertSelective(SessionMapping record);

    int deleteById(String id);

    SessionMapping selectById(String id);
}
