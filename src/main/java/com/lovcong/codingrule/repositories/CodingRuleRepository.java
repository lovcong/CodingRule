package com.lovcong.codingrule.repositories;

import com.lovcong.codingrule.CodingRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CodingRuleRepository extends JpaRepository<CodingRuleEntity, Integer> {

}
