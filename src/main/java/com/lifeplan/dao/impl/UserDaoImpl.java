package com.lifeplan.dao.impl;

import com.lifeplan.dao.UserDao;
import com.lifeplan.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * Created on 2/8/14.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    MongoTemplate mongoTemplate;

    private static final String COLLECTION_USER="user";
    @Override
    public void addUser(User user) {
        if(!mongoTemplate.collectionExists(User.class)){
            mongoTemplate.createCollection(COLLECTION_USER);
        }
        if(StringUtils.isEmpty(user.getId())){
            user.setId(UUID.randomUUID().toString());
        }
        mongoTemplate.insert(user,COLLECTION_USER);
    }

    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class, COLLECTION_USER);
    }
}
