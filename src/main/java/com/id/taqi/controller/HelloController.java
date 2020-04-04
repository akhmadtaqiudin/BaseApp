package com.id.taqi.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(name = "/",method = RequestMethod.GET)
	public HashMap<String, Object> hello(){
		HashMap<String, Object> rest = new HashMap<String, Object>();
		rest.put("Status Code", "00000");
		rest.put("Status Message", "Success");
		return rest;
	}
}
