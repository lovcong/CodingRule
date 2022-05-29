package com.lovcong.codingrule;

import com.lovcong.codingrule.impls.segments.DateRuleSegment;
import com.lovcong.codingrule.impls.segments.FixedRuleSegment;
import com.lovcong.codingrule.impls.segments.SerialNoRuleSegment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.UUID;

@SpringBootTest
class CodingruleApplicationTests {

    @Autowired
    ApplicationContext _applicationContext;

    @Test
    void generateCode() throws ClassNotFoundException {
        CodingRuleEntity codingRuleEntity = new CodingRuleEntity();
        var segment1 = new SegmentEntity();
        segment1.setName("testSegment1");
        segment1.setConfigValue("{\"fixedText\":\"AA\"}");
        segment1.setSegmentClassName(FixedRuleSegment.class.getName());
        codingRuleEntity.addSegment(segment1);
        var segment2 = new SegmentEntity();
        segment2.setName("testSegment2");
        segment2.setConfigValue("{\"format\":\"yyyyMMdd\"}");
        segment2.setSegmentClassName(DateRuleSegment.class.getName());
        codingRuleEntity.addSegment(segment2);
        var segment3 = new SegmentEntity();
        segment3.setName("testSegment3");
        segment3.setConfigValue("{\"bits\":4,\"stepNo\":1,\"initialValue\":1}");
        segment3.setSegmentClassName(SerialNoRuleSegment.class.getName());
        codingRuleEntity.addSegment(segment3);
        var codingRule = codingRuleEntity.getCodingRule(_applicationContext);
        var code= codingRule.GenerateCode();
        Assert.isTrue(!code.isEmpty(),"");
    }
}
