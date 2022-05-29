package com.lovcong.codingrule;

import com.lovcong.codingrule.abstracts.IRuleSegment;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_codingrule")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CodingRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(length = 32)
    private int id;

    public CodingRuleEntity() {
        segments = new ArrayList<SegmentEntity>();
    }

//    public CodingRuleEntity(UUID id) {
//        this();
//        this.id = id;
//    }

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "codingRule",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<SegmentEntity> segments;

    public void addSegment(SegmentEntity entity) {
        segments.add(entity);
    }

    public CodingRule getCodingRule(ApplicationContext context) throws ClassNotFoundException {
        CodingRule codingRule = new CodingRule();
        for (var segment : segments) {
            var classType = ClassLoader.getSystemClassLoader().loadClass(segment.getSegmentClassName());
            codingRule.AddSegment((IRuleSegment) context.getBean(classType, segment.getConfigValue(), segment.getId()));
        }
        return codingRule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
