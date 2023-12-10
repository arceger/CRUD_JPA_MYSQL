package com.over.CrudJpa.domain.user;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity(name="users")
@Table(name="users")
@EqualsAndHashCode(of="id")
public class Users implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String nome;
    
    private String tel;
    
    private String email;
    
    private String city;
    
    private String endereco;
    
    
    
    public Users() {
		super();
	}

	public Users(RequestUser requestUser) {
    	this.nome = requestUser.nome();
    	this.endereco = requestUser.endereco();
    	this.email = requestUser.email();
    	this.city = requestUser.city();
    	this.tel = requestUser.tel();
    	
    }
 
    public Users(UpdateUser requestUser) {
    	this.nome = requestUser.nome();
    	this.endereco = requestUser.endereco();
    	this.email = requestUser.email();
    	this.city = requestUser.city();
    	this.tel = requestUser.tel();
    	
    }
    
    @Getter
	@Setter
	public static class DeleteRequest {
        private String id;
        
        public DeleteRequest() {
        }

    }

}
