package com.lovcong.codingrule.domains;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_serialnorecord")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SerialNoRecord {

//    public SerialNoRecord(UUID id) {
//        id = UUID.randomUUID();
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int segmentId;

    @Column
    private int currentVal;

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public int getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(int currentVal) {
        this.currentVal = currentVal;
    }
}
