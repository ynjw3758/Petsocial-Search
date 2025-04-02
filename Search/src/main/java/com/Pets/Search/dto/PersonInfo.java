package com.Pets.Search.dto;


import jakarta.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class PersonInfo {
	
	@NotEmpty(message="필수")
	private String id;
	
	@NotEmpty(message="필수")
	private String nickname;
	
	@NotEmpty(message="필수")
	private String img;	

}
