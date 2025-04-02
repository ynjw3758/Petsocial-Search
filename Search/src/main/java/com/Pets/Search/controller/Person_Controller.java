package com.Pets.Search.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Pets.Search.dto.PersonInfo;
import com.Pets.Search.service.Person_Service;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/Pets-social")
public class Person_Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Person_Service Person;
	
	@GetMapping("/Search/MatList")
	public ResponseEntity<List<PersonInfo>>MatList(@RequestParam("Nickname") String nickname,
			@RequestParam("Id") String Id){
		List<PersonInfo> data = new ArrayList<PersonInfo>();
		Map<String, Object> response = new HashMap<String, Object>();
		response = Person.Search_MatFollower(nickname, Id);
		logger.info("결과 :" + response);
		if(response.get("code").equals(204)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(data);
		}
		logger.info("데이터 :" + response.get("data"));
		data = (List<PersonInfo>) response.get("data");
		return ResponseEntity.status(HttpStatus.OK).body(data);
		
	}
	

	@GetMapping("/Search/Person")
	public ResponseEntity<List<PersonInfo>>getPerson(@RequestParam("Word") String Search){
		Map<String, Object> response = new HashMap<String, Object>();
		List<PersonInfo> data = new ArrayList<PersonInfo>();
		response =Person.Search_Person(Search); 
		logger.info("최종 결과 :" + response);
		if(!response.get("data").equals("null") && response.get("code").equals(200)) {
			data =(List<PersonInfo>) response.get("data"); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

}
