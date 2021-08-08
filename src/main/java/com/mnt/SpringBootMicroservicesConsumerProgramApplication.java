package com.mnt;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mnt.config.MainConfiguration;

@SpringBootApplication
@Import(MainConfiguration.class)
public class SpringBootMicroservicesConsumerProgramApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesConsumerProgramApplication.class, args);
		 RestTemplate restTemplate=new RestTemplate();
		 String baseUrl="http://localhost:8989/";
		getALlRecordsDetails(restTemplate,baseUrl);
		
		
	}

	
	private static void getALlRecordsDetails(RestTemplate restTemplate, String baseUrl) {
		HttpHeaders headers=new HttpHeaders();
		headers.set("requestType", "application/json");
           HttpEntity<Object> httpRequest=new HttpEntity<Object>(headers);
           ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"fetchAll",HttpMethod.GET, httpRequest,String.class);
           System.out.println(responseEntity.getStatusCode());
           System.out.println(responseEntity.getBody());
	}

}
