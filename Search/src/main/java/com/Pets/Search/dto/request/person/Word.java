package com.Pets.Search.dto.request.person;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Word {
	
    @NotBlank(message = "상대아이디는 필수입니다.")
    private String word;
    
    public void setWord(String word) {
    	this.word = word;
    }
    
    public String getWord() {
    	return word;
    }

}
