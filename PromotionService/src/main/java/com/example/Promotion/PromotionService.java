package com.example.Promotion;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.azure.core.http.rest.Page;
@Service

public class PromotionService implements PromotionServiceInterface {

	@Autowired
	PromotionRepository repo;
	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPromotionByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findByCode(String name, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}




	
	public com.azure.core.http.rest.Page<Promotion> findByName(String name, Pageable pageable) {
		return null;
	}
	
	


	@Override
	
	public Page<Promotion> findById(int id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


    public boolean checkCode(String code) {
   	 List<Promotion> Promotion = repo.findByCode(code);
		    if (!Promotion.isEmpty()) {
		        return true;
		    }else {
		    	return false;
		    }
    }

	@Override
	public Page<Promotion> findByCode(String code, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  public void setStatus(String code,String status) {
	    	 List<Promotion> Promotion = repo.findByCode(code);
			    if (!Promotion.isEmpty()) {
			    	Promotion result = Promotion.get(0);
			       result.setStatus(status);
			       repo.save(result);
			    }
	    }
}

