package com.example.UserAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

@RestController

public class UserRestController {

    @Autowired
    UserService service;
    @Autowired
    UserRepository repo;
    
    //http://localhost:8888/findUserAccount?name=
    @GetMapping("/findUserAccount")
    public UserAccount findUserAccountByName(@RequestParam String name) {
      UserAccount user = service.findUserAccountByUserName(name) ;
      return user;
    }

    // http://localhost:8888/api/UserAccounts
    @GetMapping(value = "/UserAccounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAccount>> getResponseJsonContent() {
        List<UserAccount> UserAccounts = service.getAllUser();
        return ResponseEntity.ok(UserAccounts);
    }

    // http://localhost:8888/api/UserAccount?name=
    @GetMapping(value = "/UserAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccount> getUserAccountByName(@RequestParam String name) {
        UserAccount cust = service.findUserAccountByUserName(name);
        return ResponseEntity.ok(cust);
    }

    // http://localhost:8888/api/UserAccountsAll
    @PostMapping(value = "/UserAccountsAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<UserAccount>> postUserAccountsAll() {
        List<UserAccount> UserAccounts = service.getAllUser();
        return ResponseEntity.ok(UserAccounts);
    }
    
    @GetMapping("/edit/{name}/{email}/{username}")
    public ResponseEntity<String> AccountData(@PathVariable String name, @PathVariable String email, @PathVariable String username) {
    	   
  	    	 List<UserAccount> user = repo.findByName(name);
  			    if (!user.isEmpty()) {
  			        UserAccount result = user.get(0);
  			       result.setEmail(email);
  			       result.setUser(username);
  			       repo.save(result);
  			    }
				return ResponseEntity.ok("success");
  	    }
    
}
    
