package com.over.CrudJpa.domain.user;

import jakarta.validation.constraints.NotBlank;

	
	public record UpdateUser(
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


