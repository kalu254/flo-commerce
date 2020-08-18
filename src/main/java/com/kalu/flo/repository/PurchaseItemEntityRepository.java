package com.kalu.flo.repository;

import com.kalu.flo.model.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemEntityRepository extends JpaRepository<PurchaseItemEntity, Integer> {
}
