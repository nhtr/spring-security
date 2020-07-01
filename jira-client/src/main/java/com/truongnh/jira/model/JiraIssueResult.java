package com.truongnh.jira.model;

import java.util.List;

public class JiraIssueResult {
	private int startIndex;
	private int maxResults;
	private int total;
	private List<JiraIssue> listIssue;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<JiraIssue> getListIssue() {
		return listIssue;
	}
	public void setListIssue(List<JiraIssue> listIssue) {
		this.listIssue = listIssue;
	}
	
	
}
