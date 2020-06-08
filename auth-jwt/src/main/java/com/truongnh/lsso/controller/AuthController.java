package com.truongnh.lsso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@GetMapping("ping")
    public ResponseEntity<String> ping(@PathVariable String name) {
        return new ResponseEntity<>("Hello" + name, OK);
    }
	
}
