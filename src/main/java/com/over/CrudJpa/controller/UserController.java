package com.over.CrudJpa.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.over.CrudJpa.domain.user.RequestUser;
import com.over.CrudJpa.domain.user.UpdateUser;
import com.over.CrudJpa.domain.user.Users;
import com.over.CrudJpa.domain.user.Users.DeleteRequest;
import com.over.CrudJpa.domain.user.UsersRepo;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersRepo repo;
	
    @SuppressWarnings("rawtypes")
    
	@GetMapping
    public ResponseEntity  getAllUsers(){
    	
    	var allUsers = repo.findAll();
        return ResponseEntity.ok(allUsers);
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping
    public ResponseEntity regUser(@RequestBody @Valid RequestUser date) {
    	
    	Users users = new Users(date);
    	repo.save(users);
		return ResponseEntity.ok().build();
    }
    
    
    @SuppressWarnings("rawtypes")
    @PutMapping
    public ResponseEntity editUser(@RequestBody @Valid UpdateUser data) {
        Users user = repo.getReferenceById(data.id());             
        user.setNome(data.nome());
        user.setEmail(data.email());
        user.setEndereco(data.endereco());
        user.setCity(data.city());
        user.setTel(data.tel());
        Users updatedUser = repo.save(user);
        return ResponseEntity.ok(updatedUser);        
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping
    public ResponseEntity delUser(@RequestBody DeleteRequest data) {
        repo.deleteById(data.getId());
        return ResponseEntity.ok("usuario deletado");
    }

}
