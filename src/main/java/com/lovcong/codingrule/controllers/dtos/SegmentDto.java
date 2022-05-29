package com.lovcong.codingrule.controllers.dtos;

import javax.persistence.Column;
import java.io.Serializable;

public class SegmentDto implements Serializable {

    private String configValue;


    private String segmentClassName;


    public String getConfigValue() {
        return configValue;
    }

    public String getSegmentClassName() {
        return segmentClassName;
    }
}
