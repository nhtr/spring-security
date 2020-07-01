package com.truongnh.lsso.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.IssueGrab;
import model.SearchIssueResult;

@RestController
@RequestMapping(value = "/api/jira")
public class JiraController {
	
	@GetMapping(value = "/{id}")
    public String findOne(@PathVariable String id) {
        IssueGrab issue = new IssueGrab();
        return issue.getIssue("REETOKEN-7").getDescription();
    }
	
	@GetMapping(value = "/search/{jql}")
    public ResponseEntity<SearchIssueResult> searchData(@PathVariable String jql) {
		IssueGrab issue = new IssueGrab();
        try {
        	SearchIssueResult data = issue.searchIssue(jql);
			return ResponseEntity.status(HttpStatus.OK)
			        .body(data);
		} catch (Exception e) {
			return null;
		}
    }
}
