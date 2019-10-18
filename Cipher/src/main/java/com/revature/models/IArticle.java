package com.revature.models;

public interface IArticle {

	long getArticleid();

	void setArticleid(long articleid);

	String getArticlesourceid();

	void setArticlesourceid(String articlesourceid);

	String getArticletitle();

	void setArticletitle(String articletitle);

	String getArticlesymbols();

	void setArticlesymbols(String articlesymbols);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}