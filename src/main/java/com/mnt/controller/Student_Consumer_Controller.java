package com.mnt.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Student_Consumer_Controller 
{

	RestTemplate restTemplate=new RestTemplate();
	String baseUrl="http://localhost:8989/";
	@GetMapping("/findOne/{id}")
	private String getOneRecord(@RequestParam String id)
	{    
		HttpHeaders headers=new HttpHeaders();
		headers.add("requestType", "application/json");
		HttpEntity<Object> entity=new HttpEntity<Object>(headers);
		
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"fetchOne/"+id, HttpMethod.GET, entity, String.class);
		
		System.out.println("fetchOne Record::::"+responseEntity.getBody());
		return responseEntity.getBody();
	}
	
	
}
