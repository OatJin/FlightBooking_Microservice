package com.example.Promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    List<Promotion> findByCode(String name);

    Promotion findCodeById(int id);


    Page<Promotion> findByCode(String code, Pageable pageable);
}
