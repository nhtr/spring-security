package com.truongnh.jira.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.truongnh.jira.model.JiraIssue;
import com.truongnh.jira.model.JiraClientConnect;
import com.truongnh.jira.model.JiraIssueResult;

public class IssueService {
	private JiraRestClient restClient;
	
	public IssueService() {
		JiraClientConnect jiraClient = new JiraClientConnect("truongnh3.os", "123456", "https://jira.tpb.vn/");
		// JiraClientConnect jiraClient = new JiraClientConnect("truongnh.itvn", "truong00", "https://lasadu.vn/jira");
		this.restClient = jiraClient.getRestClient();
	}
	public Issue getIssue(String issueKey) {
	    return restClient.getIssueClient()
	      .getIssue(issueKey) 
	      .claim();
	}
	
	public JiraIssueResult searchIssue(String jql) throws InterruptedException, ExecutionException {
		SearchResult data = restClient.getSearchClient().searchJql(jql).get();
		JiraIssueResult result = new JiraIssueResult();
		result.setListIssue(new ArrayList<>());
		result.setMaxResults(data.getMaxResults());
		result.setStartIndex(data.getStartIndex());
		result.setTotal(data.getTotal());
		data.getIssues().forEach(iss -> result.getListIssue().add(new JiraIssue(iss.getId().toString(), iss.getKey(), iss.getSummary())));
	    return result;
	}
}
