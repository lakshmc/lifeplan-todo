package com.lifeplan.controllers.common;

import org.springframework.http.MediaType;

/**
 * Created on 2/18/14.
 */
public class LifeplanMediaType {

    public static final String LIFEPLAN_V1_JSON = "application/lifeplan-v1+json";
    public static final MediaType MEDIA_TYPE_LIFEPLAN_V1_JSON;

    static {
        MEDIA_TYPE_LIFEPLAN_V1_JSON = MediaType.valueOf(LIFEPLAN_V1_JSON);
    }

}
