package com.example.UserAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {

    List<UserAccount> findByName(String name);

    UserAccount findUserAccountByName(String userName);


    Page<UserAccount> findByName(String name, Pageable pageable);

	UserAccount findByUsername(String username);
}