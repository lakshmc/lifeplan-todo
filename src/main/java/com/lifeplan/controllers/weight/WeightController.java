package com.lifeplan.controllers.weight;

import com.lifeplan.dao.physicalattributes.weight.WeightDao;
import com.lifeplan.models.physicalattributes.weight.DailyWeight;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created on 3/10/14.
 */
@Controller
@RequestMapping(value = "rest/physicalattributes/weight")
public class WeightController {
    private Logger log = Logger.getLogger(WeightController.class);

    @Autowired
    private WeightDao weightDao;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<DailyWeight>> getAllDailyWeight() {
        return new ResponseEntity<List<DailyWeight>>(weightDao.getAllDailyWeight(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity addDailyWeight(@RequestBody @Valid DailyWeight dailyWeight, BindingResult result) {
        log.debug(dailyWeight);
        if (result.hasErrors()) {
            return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        } else {
            weightDao.addDailyWeight(dailyWeight);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
