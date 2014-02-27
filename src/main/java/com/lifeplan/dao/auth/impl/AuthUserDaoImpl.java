package com.lifeplan.dao.auth.impl;

import com.lifeplan.dao.AbstractMongoHelper;
import com.lifeplan.dao.UserDao;
import com.lifeplan.dao.auth.AuthUserDao;
import com.lifeplan.models.exception.InvalidAuthUserException;
import com.lifeplan.models.exception.UserNotFoundException;
import com.lifeplan.models.exception.UsernameAlreadyExistsException;
import com.lifeplan.models.user.auth.AuthUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created on 2/27/14.
 */
@Repository
public class AuthUserDaoImpl extends AbstractMongoHelper implements AuthUserDao {
    Logger log = Logger.getLogger(AuthUserDaoImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public AuthUser getAuthUserByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            throw new IllegalArgumentException("Null or empty value:" + userName);
        }
        return findDocumentByField("username", userName, AuthUser.class);
    }


    @Override
    public void addAuthUser(AuthUser authUser) {
        validate(authUser);
        createDocument(authUser);
        log.debug("Added AuthUser " + authUser.getUsername());
    }

    @Override
    public boolean authUserExists(AuthUser authUser) {
        if (hasRequiredFields(authUser)) {
            Query q = new Query(Criteria.where("username").is(authUser.getUsername()).andOperator(Criteria.where("password").is(authUser.getPassword())));
            AuthUser au = mongoTemplate.findOne(q, AuthUser.class);
            return au != null;
        } else {
            throw new InvalidAuthUserException("Null or empty value:" + authUser);
        }
    }

    private void validate(AuthUser authUser) {
        if (!hasRequiredFields(authUser)) {
            throw new InvalidAuthUserException("Null or empty value:" + authUser);
        }
        if (!hasMatchingUser(authUser)) {
            throw new UserNotFoundException("username:" + authUser.getUsername());
        }
        if (isAuthUserExists(authUser)) {
            throw new UsernameAlreadyExistsException(authUser.getUsername());
        }
    }

    private boolean hasRequiredFields(AuthUser authUser) {
        return !(StringUtils.isEmpty(authUser.getUsername()) || StringUtils.isEmpty(authUser.getPassword()));
    }

    private boolean hasMatchingUser(AuthUser authUser) {
        return userDao.getUserByUserName(authUser.getUsername()) != null;
    }

    private boolean isAuthUserExists(AuthUser authUser) {
        AuthUser au = this.getAuthUserByUserName(authUser.getUsername());
        return au != null;
    }

}
