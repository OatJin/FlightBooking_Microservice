package com.example.UserAccount;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.microsoft.aad.msal4j.IAccount;

import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
@Service
public class UserService implements UserServiceInterface {
	@Autowired
	private UserRepository repo;
	@Override
	public List<UserAccount> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccount> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserByName(String ticketName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccount> findByName(String name, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean matchUsername(String username) {
        // Check if the username exists in the database
        UserAccount user = repo.findByUsername(username);
        return user != null;
    }
    
	
	@Override
	public com.azure.core.http.rest.Page<UserAccount> findByName(String name, Pageable pageable) {
		return null;
	}
	
	@Override
	public com.azure.core.http.rest.Page<UserAccount> findByUserName(String username, Pageable pageable) {
		return null;
	}
	
	public UserAccount findUserAccountByUserName(String username) {
	    List<UserAccount> users = repo.findByName(username);
	    if (!users.isEmpty()) {
	        UserAccount result = users.get(0);
	        System.out.printf("%d) name:%s, email:%s %n", result.getId(), result.getName(), result.getEmail());
	        return result;
	    } else {
	        // กรณีไม่พบ Customer
	        return null;
	    }
	}

  
    

	
}
