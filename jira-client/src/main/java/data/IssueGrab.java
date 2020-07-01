package data;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;

import config.MyJiraClient;
import model.IssueResult;
import model.SearchIssueResult;

public class IssueGrab {
	private JiraRestClient restClient;
	
	public IssueGrab() {
		MyJiraClient jiraClient = new MyJiraClient("truongnh3.os", "123456", "https://jira.tpb.vn/");
		this.restClient = jiraClient.getRestClient();
	}
	public Issue getIssue(String issueKey) {
	    return restClient.getIssueClient()
	      .getIssue(issueKey) 
	      .claim();
	}
	
	public SearchIssueResult searchIssue(String jql) throws InterruptedException, ExecutionException {
		SearchResult data = restClient.getSearchClient().searchJql(jql).get();
		SearchIssueResult result = new SearchIssueResult();
		result.setListIssue(new ArrayList<>());
		result.setMaxResults(data.getMaxResults());
		result.setStartIndex(data.getStartIndex());
		result.setTotal(data.getTotal());
		data.getIssues().forEach(iss -> result.getListIssue().add(new IssueResult(iss.getId().toString(), iss.getKey(), iss.getSummary())));
	    return result;
	}
}
