package com.truongnh.lsso.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {
	
	@GetMapping("ping/{name}")
	public ResponseEntity<String> ping(@PathVariable String name) {
		return new ResponseEntity<>("Hello " + name, OK);
	}
	
}
