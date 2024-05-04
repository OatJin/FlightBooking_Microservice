package com.example.UserAccount;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

import com.azure.core.http.rest.Page;

public interface UserServiceInterface {
	List<UserAccount> getAllUser();
	public List<UserAccount> findByName(String name) ;
	

	String findUserByName(String ame);
    List<UserAccount> findByName(String name, Sort sort);
    Page<UserAccount> findByName(String name, Pageable pageable);
	Page<UserAccount> findByUserName(String username, Pageable pageable);
}
