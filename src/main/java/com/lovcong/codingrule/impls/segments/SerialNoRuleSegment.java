package com.lovcong.codingrule.impls.segments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovcong.codingrule.abstracts.RuleSegmentBase;
import com.lovcong.codingrule.domains.SerialNoRecord;
import com.lovcong.codingrule.repositories.SerialNoRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class SerialNoRuleSegment extends RuleSegmentBase<SerialNoSegmentConfig> {

    boolean needToAddRecord=false;

    @Autowired
    SerialNoRecordRepository serialNoRecordRepository;

    public SerialNoRuleSegment(String configJson, int id) throws JsonProcessingException {
        super(configJson, id);
    }

    @Override
    public String GeneratePart() {
        SerialNoRecord serialNoRecord;
        var serialNoRecords = serialNoRecordRepository.findBySegmentId(this.id);
        if (serialNoRecords.size() > 0) {
            serialNoRecord = serialNoRecords.get(0);
        } else {
            serialNoRecord = new SerialNoRecord();
            serialNoRecord.setCurrentVal(SegmentConfig.getInitialValue());
            serialNoRecord.setSegmentId(this.id);
            needToAddRecord = true;
        }
        var format = "%0" + SegmentConfig.getBits() + "d";
        var result = String.format(format, (serialNoRecord.getCurrentVal() + SegmentConfig.getStepNo()));
        serialNoRecord.setCurrentVal(serialNoRecord.getCurrentVal()+ SegmentConfig.getStepNo());
//        if(needToAddRecord){
            serialNoRecordRepository.save(serialNoRecord);
//        }
        return result;
    }
}
