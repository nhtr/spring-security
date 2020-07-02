package com.truongnh.lsso.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truongnh.jira.model.JiraIssueResult;
import com.truongnh.jira.service.IssueService;

@RestController
@RequestMapping(value = "/api/jira")
public class JiraController {

	@GetMapping(value = "/{id}")
	public String findOne(@PathVariable String id) {
		IssueService issue = new IssueService();
		return issue.getIssue("REETOKEN-7").getDescription();
	}

	@GetMapping(value = "/search/{jql}")
	public ResponseEntity<JiraIssueResult> searchData(@PathVariable String jql) {
		IssueService issue = new IssueService();
		try {
			JiraIssueResult data = issue.searchIssue(jql);
			return ResponseEntity.status(HttpStatus.OK).body(data);
		} catch (Exception e) {
			return null;
		}
	}
}
