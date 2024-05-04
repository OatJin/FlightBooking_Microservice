package com.example.Promotion;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;


import com.azure.core.http.rest.Page;

public interface PromotionServiceInterface {
	List<Promotion> getAllPromotion();
	public List<Promotion> findByName(String name) ;
	

	String findPromotionByCode(String code);
    List<Promotion> findByCode(String code, Sort sort);
    Page<Promotion> findByCode(String code, Pageable pageable);


	Page<Promotion> findById(int id, Pageable pageable);
}
