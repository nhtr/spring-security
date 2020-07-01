package config;

import java.net.URI;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class MyJiraClient {
	private String username;
	private String password;
	private String jiraUrl;
	private JiraRestClient restClient;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJiraUrl() {
		return jiraUrl;
	}

	public void setJiraUrl(String jiraUrl) {
		this.jiraUrl = jiraUrl;
	}

	public JiraRestClient getRestClient() {
		return restClient;
	}

	public void setRestClient(JiraRestClient restClient) {
		this.restClient = restClient;
	}

	public MyJiraClient(String username, String password, String jiraUrl) {
	    this.username = username;
	    this.password = password;
	    this.jiraUrl = jiraUrl;
	    this.restClient = getJiraRestClient();
	}
	
	private JiraRestClient getJiraRestClient() {
	    return new AsynchronousJiraRestClientFactory()
	      .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
	}
	
	private URI getJiraUri() {
	    return URI.create(this.jiraUrl);
	}
}
