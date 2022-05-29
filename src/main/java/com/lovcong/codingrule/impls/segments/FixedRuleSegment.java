package com.lovcong.codingrule.impls.segments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovcong.codingrule.abstracts.RuleSegmentBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.util.UUID;

@Component
@Scope("prototype")
public class FixedRuleSegment extends RuleSegmentBase<FixedRuleSegmentConfig> {


    public FixedRuleSegment(String configJson, int id) throws JsonProcessingException {
        super(configJson, id);
    }

    @Override
    public String GeneratePart() {
        return SegmentConfig.getFixedText();
    }
}
