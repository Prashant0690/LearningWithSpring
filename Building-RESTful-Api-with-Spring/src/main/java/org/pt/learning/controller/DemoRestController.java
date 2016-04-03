package org.pt.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@RequestMapping(value="/api/test/" , method=RequestMethod.POST)
	public String apiTest(){
		return "Hello World";
	}

}
