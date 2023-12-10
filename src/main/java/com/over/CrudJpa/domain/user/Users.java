package com.over.CrudJpa.domain.user;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;



@Entity(name="users")
@Table(name="users")
@EqualsAndHashCode(of="ID")
public class Users implements Serializable{
	
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
    
    public static class DeleteRequest {
        private String id;
        
        public DeleteRequest() {
        }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
       
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
   
}
