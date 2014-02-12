package com.lifeplan.controllers;

import com.lifeplan.logic.UserHabitLogic;
import com.lifeplan.models.UserHabit;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on 2/7/14.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserHabitLogic userHabitLogic;

    //@RequestMapping(value="myhabits", method = RequestMethod.GET, )
    /*@RequestMapping(produces="application/json")
    public @ResponseBody List<UserHabit> getUserHabits(){
        return userHabitLogic.getUserHabits();
    }*/

    @RequestMapping("test")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "This proves that i exist!");
        return "hello";
    }

    @RequestMapping("")
    public String landingPage(ModelMap model) {
        model.addAttribute("message", ":)");
        return "default";
    }

}
