package com.lovcong.codingrule.controllers.dtos;

import java.io.Serializable;
import java.util.List;

public class AddCodingRuleDto implements Serializable {
    private String name;

    private List<SegmentDto> segmentDtos;

    public String getName() {
        return name;
    }

    public List<SegmentDto> getSegmentDtos() {
        return segmentDtos;
    }
}
