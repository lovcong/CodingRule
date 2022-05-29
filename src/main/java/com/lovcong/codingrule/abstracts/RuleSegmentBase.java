package com.lovcong.codingrule.abstracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovcong.codingrule.utils.ClassUtil;

import java.util.UUID;


public abstract class RuleSegmentBase<T> implements IRuleSegment {

    protected int id;

    protected T SegmentConfig;

    public RuleSegmentBase(String configJson,int id) throws JsonProcessingException {
        this.id = id;
        var genericType = ClassUtil.getClassT(this, 0);
        SegmentConfig =(T)  new ObjectMapper().readValue(configJson,genericType);
    }

    @Override
    public abstract String GeneratePart();


}
