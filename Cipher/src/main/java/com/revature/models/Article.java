package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table
public class Article implements Serializable, IArticle {


	

	private static final long serialVersionUID = -5780629822500942335L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="article_id")
	private long articleid;
	
	@Column(name="article_sourceid")
	private String articlesourceid;
	
	@Column(name="article_title")
	private String articletitle;
	
	@Column(name="article_sysmbols")
	private String articlesymbols;
	
	public Article() {
		super();
	}

	public Article(long articleid, String articlesourceid, String articletitle, String articlesymbols) {
		super();
		this.articleid = articleid;
		this.articlesourceid = articlesourceid;
		this.articletitle = articletitle;
		this.articlesymbols = articlesymbols;
	}

	@Override
	public long getArticleid() {
		return articleid;
	}

	@Override
	public void setArticleid(long articleid) {
		this.articleid = articleid;
	}

	@Override
	public String getArticlesourceid() {
		return articlesourceid;
	}

	@Override
	public void setArticlesourceid(String articlesourceid) {
		this.articlesourceid = articlesourceid;
	}

	@Override
	public String getArticletitle() {
		return articletitle;
	}

	@Override
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	@Override
	public String getArticlesymbols() {
		return articlesymbols;
	}

	@Override
	public void setArticlesymbols(String articlesymbols) {
		this.articlesymbols = articlesymbols;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleid, articlesourceid, articlesymbols, articletitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return articleid == other.articleid && Objects.equals(articlesourceid, other.articlesourceid)
				&& Objects.equals(articlesymbols, other.articlesymbols)
				&& Objects.equals(articletitle, other.articletitle);
	}

	@Override
	public String toString() {
		return "Article [articleid=" + articleid + ", articlesourceid=" + articlesourceid + ", articletitle="
				+ articletitle + ", articlesymbols=" + articlesymbols + "]";
	}	
	
	
}
