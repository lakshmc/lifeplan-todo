package com.lifeplan.controllers.activity;

import com.lifeplan.dao.activity.ActivityDao;
import com.lifeplan.models.activity.ActivityFixtures;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created on 2/18/14.
 */
public class ActivityControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    ActivityController controller;

    @Mock
    ActivityDao activityDao;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller).build();

        when(activityDao.getAllActivity()).thenReturn(ActivityFixtures.getAllActivities());
    }

    @Test
    public void thatGetAllActivitiesReturnsJson() throws Exception {
        this.mockMvc.perform(
                get("/activities").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

}
