package com.lovcong.codingrule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_segment")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SegmentEntity {

    public  SegmentEntity(){

    }

//    public SegmentEntity(UUID id){
//        this.id = id;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column
//    private UUID ruleId;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String configValue;

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Column
    private String segmentClassName;

    public String getSegmentClassName() {
        return segmentClassName;
    }

    public void setSegmentClassName(String segmentClassName) {
        this.segmentClassName = segmentClassName;
    }

    public int getId() {
        return id;
    }

//    public UUID getRuleId() {
//        return ruleId;
//    }
//
//    public void setRuleId(UUID ruleId) {
//        this.ruleId = ruleId;
//    }

    @ManyToOne
    @JoinColumn( name="ruleId" )
    @JsonBackReference
    private CodingRuleEntity codingRule;

    public CodingRuleEntity getCodingRule() {
        return codingRule;
    }

    public void setCodingRule(CodingRuleEntity codingRule) {
        this.codingRule = codingRule;
    }
}
