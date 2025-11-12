package com.dell.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class VersioningPersonController {
	
	//http://localhost:8080/v1/person
	@GetMapping("/v1/person")
	public Person1 getFirstVersionOfPerson() {
		return new Person1("Nagarjuna Gangarapu");
	}
	
	
	//http://localhost:8080/v2/person
	@GetMapping("/v2/person")
	public Person2 getSecondVersionOfPerson() {
		return new Person2(new Name("Nagarjuna", "Gangarapu"));
	}
	

	//http://localhost:8080/person?version=1
	@GetMapping(path="/person" , params = "version=1")
	public Person1 getFirstVersionOfPersonRequestParameter() {
		return new Person1("Nagarjuna Gangarapu");
	}
	
	//http://localhost:8080/person?version=2
	@GetMapping(path="/person" , params = "version=2")
	public Person2 getSecondVersionOfPersonRequestParameter() {
		return new Person2(new Name("Nagarjuna", "Gangarapu"));
	}
	
	//http://localhost:8080/person/header
	@GetMapping(path="/person/header" , headers =  "X-API-VERSION=1")
	public Person1 getFirstVersionOfPersonRequestHeader() {
		return new Person1("Nagarjuna Gangarapu");
	}
	
	//http://localhost:8080/person/header
	@GetMapping(path="/person/header" , headers =  "X-API-VERSION=2")
	public Person2 getSecondVersionOfPersonRequestHeader() {
		return new Person2(new Name("Nagarjuna", "Gangarapu"));
	}
	
	
	    //http://localhost:8080/person/accept
		@GetMapping(path="/person/accept" , produces = "application/vnd.company.app-v1+json")
		public Person1 getFirstVersionOfPersonAcceptHeader() {
			return new Person1("Nagarjuna Gangarapu");
		}
		
		  //http://localhost:8080/person/accept
		@GetMapping(path="/person/accept" , produces = "application/vnd.company.app-v2+json")
		public Person2 getSecondVersionOfPersonAcceptHeader() {
			return new Person2(new Name("Nagarjuna", "Gangarapu"));
		}
		
	
	
}
