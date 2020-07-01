package model;

import java.util.List;

public class SearchIssueResult {
	private int startIndex;
	private int maxResults;
	private int total;
	private List<IssueResult> listIssue;
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
	public List<IssueResult> getListIssue() {
		return listIssue;
	}
	public void setListIssue(List<IssueResult> listIssue) {
		this.listIssue = listIssue;
	}
	
	
}
