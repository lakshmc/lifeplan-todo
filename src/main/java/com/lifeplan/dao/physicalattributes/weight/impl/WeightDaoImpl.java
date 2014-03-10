package com.lifeplan.dao.physicalattributes.weight.impl;

import com.lifeplan.dao.AbstractMongoHelper;
import com.lifeplan.dao.UserDao;
import com.lifeplan.dao.physicalattributes.weight.WeightDao;
import com.lifeplan.logic.util.DateUtil;
import com.lifeplan.models.exception.UserNotFoundException;
import com.lifeplan.models.physicalattributes.weight.DailyWeight;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 3/10/14.
 */
@Service
public class WeightDaoImpl extends AbstractMongoHelper implements WeightDao {

    @Autowired
    private UserDao userDao;

    @Override
    public List<DailyWeight> getAllDailyWeight() {
        return loadAll(DailyWeight.class);
    }

    @Override
    public void addDailyWeight(DailyWeight dailyWeight) {
        validate(dailyWeight);
        if (dailyWeight.getTimestamp() == null) {
            DateTime dt = DateUtil.getUTCDateTimeStamp();
            dailyWeight.setTimestamp(dt);
            dailyWeight.setLastModified(dt);
        }
        createDocument(dailyWeight);
    }

    private void validate(DailyWeight dailyWeight) {
        if (null == dailyWeight) {
            throw new IllegalArgumentException("DailyWeight cannot be null when adding new entry");
        }
        if (!userDao.isUsernameExists(dailyWeight.getUsername())) {
            throw new UserNotFoundException("username:" + dailyWeight.getUsername());
        }

    }
}
