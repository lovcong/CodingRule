package com.lovcong.codingrule.repositories;

import com.lovcong.codingrule.domains.SerialNoRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface SerialNoRecordRepository extends JpaRepository<SerialNoRecord, Integer> {

     List<SerialNoRecord> findBySegmentId(int id);
}
