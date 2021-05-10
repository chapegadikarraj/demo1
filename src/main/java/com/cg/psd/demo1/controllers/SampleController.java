package com.cg.psd.demo1.controllers;

import java.net.URI;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.psd.demo1.model.Profile;
import com.cg.psd.demo1.proxy.Demo2Proxy;
import com.cg.psd.demo1.service.ProfileService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/demo1")
public class SampleController {
	
	static int count=0;
	
	@Value("${Demo1.name:name}")
	private String name;
	
	@Autowired
	private Demo2Proxy proxy;
	
	@Autowired
	private Environment environemnt;
	
	@Autowired
	private ProfileService service;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String funException(){
		
		return "Hello World";
	}
	
	@RequestMapping(value="/funPost",method=RequestMethod.POST, produces="application/xml")
	public Profile funPost(
			/* @Valid */@RequestBody Profile profile, 
			@RequestHeader(value= "HEADER1", required=false) String header1){
			service.saveProfile(profile);
		return profile;
		
	}

	@RequestMapping(value="/funGet/{name}", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallBack")
	public String funGet(
			@RequestHeader(value= "HEADER1", required=false) String header1,
			@PathVariable(value="name", required= true) String name){
			String str = new RestTemplate().postForObject(URI.create("http://localhost:8083/demo2/funPost"), new Profile(), String.class);
		return str;
		
	}
	
	@RequestMapping(value="/funGetFeign/{name}", method=RequestMethod.GET)
	public String funGetFeign(
			@RequestHeader(value= "HEADER1", required=false) String header1,
			@PathVariable(value="name", required= true) String name){
			String str = proxy.funPost(new Profile());
		return "demo2: "+str+" demo1: "+environemnt.getProperty("local.server.port");
		
	}
	
	@RequestMapping(value="/funException", method=RequestMethod.GET)
	public String funException(
			@RequestHeader(value= "HEADER1", required=false) String header1){
		if(true)
			throw new RuntimeException("Inside demo1 controller");
		return "";
	}
	
	
	// fallback method should have same method signature.
	private String fallBack(
			@RequestHeader(value= "HEADER1", required=false) String header1,
			@PathVariable(value="name", required= true) String name) {
		
		return "FallBack";
	} 
	
}
