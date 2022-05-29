package com.lovcong.codingrule.controllers;

import com.lovcong.codingrule.CodingRuleEntity;
import com.lovcong.codingrule.SegmentEntity;
import com.lovcong.codingrule.controllers.dtos.AddCodingRuleDto;
import com.lovcong.codingrule.repositories.CodingRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@Transactional
public class CodingRuleApiController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CodingRuleRepository codingRuleRepository;

    @PostMapping("/addcodingrule")
    public void AddCodingRule(@RequestBody AddCodingRuleDto dto) {
//        var ruleId = UUID.randomUUID();
        CodingRuleEntity codingRuleEntity = new CodingRuleEntity();
        codingRuleEntity.setName(dto.getName());
        for (var segmentDto : dto.getSegmentDtos()) {
            SegmentEntity segmentEntity = new SegmentEntity();
            segmentEntity.setSegmentClassName(segmentDto.getSegmentClassName());
            segmentEntity.setConfigValue(segmentDto.getConfigValue());
            segmentEntity.setCodingRule(codingRuleEntity);
            codingRuleEntity.addSegment(segmentEntity);
        }
        codingRuleRepository.save(codingRuleEntity);
    }

    @GetMapping("/generatecode")
    public String GenerateCode(int ruleId) throws ClassNotFoundException {
        var codingRuleEntity = codingRuleRepository.findById(ruleId);
        var codingRule = codingRuleEntity.get().getCodingRule(applicationContext);
        return codingRule.GenerateCode();
    }
}
