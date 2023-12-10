package com.over.CrudJpa.domain.user;


import jakarta.validation.constraints.NotBlank;

public record RequestUser(
	    String id,
		@NotBlank
		String nome,
		@NotBlank
		String email,
		@NotBlank
		String tel,
		@NotBlank
		String city,
		@NotBlank
		String endereco) {

}
