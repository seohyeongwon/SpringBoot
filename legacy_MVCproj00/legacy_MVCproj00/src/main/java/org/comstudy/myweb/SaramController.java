package org.comstudy.myweb;

import java.util.List;

import org.comstudy.myweb.model.Saram;
import org.comstudy.myweb.service.SaramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaramController {
	
	@Autowired
	private SaramService service;
	
	@GetMapping("/saram")
	@ResponseBody
	public List<Saram> list() {
		return service.saramList();
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Name : " + name;
	}
	
}
