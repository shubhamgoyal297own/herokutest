package com.herokutest.testapp297.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public String welcomme() {
		return "Hello Anvesha";
	}
}
