package com.lifeplan.dao.auth;

import com.lifeplan.models.user.auth.AuthUser;

/**
 * Created on 2/21/14.
 */
public interface AuthUserDao {
    AuthUser getAuthUserByUserName(String userName);

    void addAuthUser(AuthUser authUser);

    boolean authUserExists(AuthUser authUser);
}
