package com.lifeplan.dao.physicalattributes.weight;

import com.lifeplan.models.physicalattributes.weight.DailyWeight;

import java.util.List;

/**
 * Created on 3/10/14.
 */
public interface WeightDao {


    List<DailyWeight> getAllDailyWeight();

    void addDailyWeight(DailyWeight dailyWeight);
}
