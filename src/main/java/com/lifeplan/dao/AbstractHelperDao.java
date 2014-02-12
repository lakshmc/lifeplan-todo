package com.lifeplan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created on 2/10/14.
 */
@Repository
public class AbstractHelperDao {
    @Autowired
    protected MongoTemplate mongoTemplate;
}
