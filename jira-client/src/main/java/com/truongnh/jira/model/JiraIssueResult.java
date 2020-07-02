package com.truongnh.jira.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JiraIssueResult {
	private int startIndex;
	private int maxResults;
	private int total;
	private List<JiraIssue> listIssue;	
}
