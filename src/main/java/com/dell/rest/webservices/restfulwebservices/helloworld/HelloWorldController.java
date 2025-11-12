package com.dell.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;



//REST API
@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}

	//URL http://localhost:8080/hello-world
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		
		return "Hello World ! Nagarjuna Gangarapu"
				+ "";
		
	}
	
	
	//If there are same API's then will get the below error
	//Ambiguous mapping. Cannot map 'helloWorldController' method 
	//com.dell.rest.webservices.restfulwebservices.helloworld.HelloWorldController#helloWorld()
	//to {GET [/hello-world]}: There is already 'helloWorldController' bean method

	/*@GetMapping(path="/hello-world")
	public String helloWorld1() {
		
		return "Hello World ! Nagarjuna Gangarapu!!!!!!!!!!"
				+ "";
		
	}*/
	
	//Calling or Consuming another REST API 
	@GetMapping("/callclienthello")
	public String getHelloClient() {
		
		String uri="http://localhost:8090/hello-world";
		RestTemplate restTemplate=new RestTemplate();
		String result= restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello World Bean");
		
	}
	
	//Path parameters 
	
	//http://localhost:8080/hello-world/path-veriable/Nagarjuna
	@GetMapping(path="/hello-world/path-veriable/{name}")
	public HelloWorldBean helloWorldPathVeriable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s",name));
		
	}
	
	//http://localhost:8080/helloWorldI18n
	@GetMapping(path="/helloWorldI18n")
	public String helloWorldI18n() {
		
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,"Default Message",locale);
		
		//return "God morning"+ "";
		
	}
	

}
