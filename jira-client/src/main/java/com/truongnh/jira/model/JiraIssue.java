package com.truongnh.jira.model;

public class JiraIssue {
	private String id;
	private String key;
	private String summary;
	
	public JiraIssue() {
		super();
	}
	public JiraIssue(String id, String key, String summary) {
		super();
		this.id = id;
		this.key = key;
		this.summary = summary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
