package com.lovcong.codingrule.impls.segments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovcong.codingrule.abstracts.RuleSegmentBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Scope("prototype")
public class DateRuleSegment extends RuleSegmentBase<DateRuleSegmentConfig> {

    public DateRuleSegment(String configJson, int id) throws JsonProcessingException {
        super(configJson,id);
    }

    @Override
    public String GeneratePart() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat(SegmentConfig.getFormat());
        return format.format(now);
    }
}
