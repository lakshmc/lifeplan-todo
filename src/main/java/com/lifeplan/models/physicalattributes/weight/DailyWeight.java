package com.lifeplan.models.physicalattributes.weight;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DailyWeight {
    @Range(min = 1, max = 500)
    private int wholePoint;
    @Range(min = 0, max = 9)
    private int decimalPoint;
    private DateTime timestamp;
    @NotNull
    @NotEmpty
    private String username;
    private DateTime lastModified;

    public int getWholePoint() {
        return wholePoint;
    }

    public void setWholePoint(int wholePoint) {
        this.wholePoint = wholePoint;
    }

    public int getDecimalPoint() {
        return decimalPoint;
    }

    public void setDecimalPoint(int decimalPoint) {
        this.decimalPoint = decimalPoint;
    }


    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DailyWeight{" +
                "weight=" + wholePoint + "." + decimalPoint +
                ", timestamp='" + timestamp + '\'' +
                ", username='" + username + '\'' +
                ", lastModified='" + lastModified + '\'' +
                '}';
    }

    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

    public DateTime getLastModified() {
        return lastModified;
    }
}
